package com.hug.common.jsonschema;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jackson.JsonNodeReader;
import com.github.fge.jsonschema.core.report.LogLevel;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.hug.common.dto.Result;
import com.hug.common.constant.enums.EnumResult;
import com.hug.common.exception.BusinessException;
import com.hug.common.exception.JsonSchemaFileNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

/**
 * jsonSchema 校验工具类
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2018-11-22 9:46
 */
@Slf4j
public class JsonSchemaUtil {

    public static void validateJson(String rParams, String schemaJson) throws Exception {
        log.info("=====>validate rParams:" + rParams);
        Result result = new Result();

        JsonNode jsonNode = JsonSchemaUtil.getJsonNodeFromString(rParams);
        if (jsonNode == null) {
            log.error("=====>error rParams:" + rParams);
            throw new BusinessException("json报文格式错误");
        }
        JsonNode schemaNode = null;
        try {
            schemaNode = JsonSchemaUtil.getJsonNodeFromFile(schemaJson);
        }catch (IOException ioe) {
            log.debug("=====>error jsonschema文件名："+schemaJson);
            throw new JsonSchemaFileNotFoundException("json Schema文件不存在，无需校验！");
        }

        JsonSchemaUtil.validateJsonByFgeByJsonNode(jsonNode, schemaNode);

    }

    private static Result validateJsonByFgeByJsonNode(JsonNode jsonNode, JsonNode schemaNode) throws BusinessException {
        Result result = new Result();
        ProcessingReport report = null;
        report = JsonSchemaFactory.byDefault().getValidator().validateUnchecked(schemaNode, jsonNode);
        if (report.isSuccess()) {
            // 校验成功
            result.setStatus(EnumResult.SUCESS.getStatus());
            result.setMessage(EnumResult.SUCESS.getMessage());
            return result;
        } else {
            log.warn("--->参数校验失败！");
            Iterator<ProcessingMessage> it = report.iterator();
            String ms = "";
            String pms = "";
            while (it.hasNext()) {
                ProcessingMessage pm = it.next();
                if (!LogLevel.WARNING.equals(pm.getLogLevel())) {
                    pms += pm;
                    ms = pm.getMessage().replaceAll("\\\"","");
                    break;
                }

            }

//            log.info("--->pms: " + pms);

            String[] prom = pms.split("\n");
            String instance = prom[3];
            instance = instance.substring(instance.lastIndexOf("/") +1, instance.lastIndexOf("\""));

            throw new BusinessException(String.format("param %s is error, %s", instance, ms));
        }
    }

    private static JsonNode getJsonNodeFromString(String jsonStr) {
        JsonNode jsonNode = null;
        try {
            jsonNode = JsonLoader.fromString(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonNode;
    }

    private static JsonNode getJsonNodeFromFile(String filePath) throws IOException {
        JsonNode jsonNode = null;

//        Resource resource = new ClassPathResource(filePath);
//        File file = resource.getFile();
//        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

//        BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(filePath)));
        ClassPathResource resource = new ClassPathResource(filePath);
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        jsonNode = new JsonNodeReader().fromReader(br);

        return jsonNode;
    }
}
