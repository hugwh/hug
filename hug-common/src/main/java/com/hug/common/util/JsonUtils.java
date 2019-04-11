package com.hug.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * json工具类
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2018-11-13 11:01
 */
public class JsonUtils {
    /**
     * 将json转化成map
     * @param jsonObject
     * @return
     */
    public static Map<String, Object> convertJsonObjectToMap(JSONObject jsonObject){
        if (jsonObject == null)
            return null;

        String jsonStr = jsonObject.toJSONString();

        Map<String, Object> map = JSON.parseObject(
                jsonStr,new TypeReference<Map<String, Object>>(){} );

        return map;
    }

    public static Map<String, String> convertJsonStrToMapString(JSONObject jsonObject){
        if (jsonObject == null)
            return null;

        String jsonStr = jsonObject.toJSONString();

        Map<String, String> map = JSON.parseObject(
                jsonStr,new TypeReference<Map<String, String>>(){} );

        return map;
    }

    public static List<Map> convertJSONArray2List (JSONArray jsonArray) {
        String listStr = JSONObject.toJSONString(jsonArray, SerializerFeature.WriteClassName);
        List<Map> list = JSONObject.parseArray(listStr, Map.class);

        return list;
    }

    /**
     * 将字符串转化为json对象
     * @param str
     * @return
     */
    public static JSONObject string2Json (String str) {
        if (StringUtils.isEmpty(str))
            return null;
        JSONObject jsonObject = JSON.parseObject(str);
        return jsonObject;
    }

//    /**
//     * 将实体对象转为json对象
//     * @param o
//     * @return
//     */
//    public static JSONObject object2Json (Object o) {
//        if (o == null)
//            return null;
//        //fastjson设置数据格式为下划线，默认为驼峰
//        SerializeConfig config = new SerializeConfig();
//        config.propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;
//
//        String jsonStr = JSON.toJSONString(o, config);
//        return JSON.parseObject(jsonStr);
//    }

    /**
     * 是否为空
     * @param jsonObject
     * @return
     */
    public static boolean isEmpty (JSONObject jsonObject) {
        return jsonObject == null || jsonObject.isEmpty();
    }
}
