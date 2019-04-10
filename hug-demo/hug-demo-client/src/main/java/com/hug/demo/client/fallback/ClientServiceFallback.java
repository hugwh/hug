package com.hug.demo.client.fallback;

import com.hug.demo.client.service.ClientService;
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
}
