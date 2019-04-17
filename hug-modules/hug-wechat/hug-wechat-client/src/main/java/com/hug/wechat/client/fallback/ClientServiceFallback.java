package com.hug.wechat.client.fallback;

import com.hug.wechat.client.service.ClientService;
import org.springframework.stereotype.Component;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-10 14:46
 */
@Component
public class ClientServiceFallback implements ClientService {
    @Override
    public String testFromClient(String name) {
        return "sorry "+name+",this service is unavailable";
    }

    @Override
    public String queryUser(String id) {
        return "error";
    }
}
