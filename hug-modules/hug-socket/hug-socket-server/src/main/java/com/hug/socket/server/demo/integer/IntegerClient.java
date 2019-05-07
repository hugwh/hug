package com.hug.socket.server.demo.integer;

import com.hug.socket.server.protocol.IntegerProtocol;
import org.smartboot.socket.transport.AioQuickClient;

/**
 * 启动客户端
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-05-07 17:53
 */
public class IntegerClient {
    public static void main(String[] args) throws Exception {
        IntegerClientProcessor processor = new IntegerClientProcessor();
        AioQuickClient<Integer> aioQuickClient = new AioQuickClient<Integer>("localhost", 18888, new IntegerProtocol(), processor);
        aioQuickClient.start();
        for (int i=0; i<20; i++) {
            processor.getSession().write(i);
            Thread.sleep(1000);
        }
        aioQuickClient.shutdown();
    }
}
