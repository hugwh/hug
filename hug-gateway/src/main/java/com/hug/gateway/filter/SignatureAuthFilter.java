package com.hug.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.hug.common.constant.ResultConstants;
import com.hug.common.constant.enums.result.CodeEnum;
import com.hug.common.constant.enums.result.ServiceEnum;
import com.hug.common.model.dto.ResultBaseDto;
import com.hug.common.model.dto.ResultDto;
import io.netty.buffer.ByteBufAllocator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.NettyDataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.nio.charset.StandardCharsets;

/**
 * 签名验证 全局过滤器
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-16 15:14
 */
@Slf4j
@Component
public class SignatureAuthFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("进入签名验证过滤器");
        ServerHttpRequest serverHttpRequest = exchange.getRequest();
        String method = serverHttpRequest.getMethodValue();

        String appId = exchange.getRequest().getHeaders().getFirst("appId");
        String signature = exchange.getRequest().getHeaders().getFirst("signature");
        log.info("appId:{}", appId);
        log.info("signature:{}", signature);

        if ("GET".equals(method)) {
            MultiValueMap<String, String> queryParams = serverHttpRequest.getQueryParams();
            log.info("get params:{}", queryParams.toString());
            return chain.filter(exchange);
        } else if ("POST".equals(method)) {
            //从请求里获取Post请求体
            String bodyStr = resolveBodyFromRequest(serverHttpRequest);
            //TODO 得到Post请求的请求参数后，做你想做的事
            log.info("post body:{}", bodyStr);

            //下面的将请求体再次封装写回到request里，传到下一级，否则，由于请求体已被消费，后续的服务将取不到值
            URI uri = serverHttpRequest.getURI();
            ServerHttpRequest request = serverHttpRequest.mutate().uri(uri).build();
            DataBuffer bodyDataBuffer = stringBuffer(bodyStr);
            Flux<DataBuffer> bodyFlux = Flux.just(bodyDataBuffer);

            request = new ServerHttpRequestDecorator(request) {
                @Override
                public Flux<DataBuffer> getBody() {
                    return bodyFlux;
                }
            };

            //封装request，传给下一级
            return chain.filter(exchange.mutate().request(request).build());
        }

        ResultBaseDto resultBaseDto = new ResultBaseDto(CodeEnum.AUTH_ERR, "签名验证失败", ServiceEnum.HUG_GATEWAY);

        ServerHttpResponse response = exchange.getResponse();
        byte[] datas = JSON.toJSONString(resultBaseDto).getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = response.bufferFactory().wrap(datas);
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");

        return response.writeWith(Mono.just(buffer));
    }

    /**
     * 从Flux<DataBuffer>中获取字符串的方法
     *
     * @return 请求体
     */
    private String resolveBodyFromRequest(ServerHttpRequest serverHttpRequest) {
        //获取请求体
        Flux<DataBuffer> body = serverHttpRequest.getBody();
        StringBuilder sb = new StringBuilder();
        body.subscribe(buffer -> {
            byte[] bytes = new byte[buffer.readableByteCount()];
            buffer.read(bytes);
            DataBufferUtils.release(buffer);
            String bodyString = new String(bytes, StandardCharsets.UTF_8);
            sb.append(bodyString);
        });
        log.info("请求体内容;{}", sb.toString());
        return sb.toString();
    }

    private DataBuffer stringBuffer(String value) {
        byte[] bytes = value.getBytes(StandardCharsets.UTF_8);

        NettyDataBufferFactory nettyDataBufferFactory = new NettyDataBufferFactory(ByteBufAllocator.DEFAULT);
        DataBuffer buffer = nettyDataBufferFactory.allocateBuffer(bytes.length);
        buffer.write(bytes);
        return buffer;
    }
}
