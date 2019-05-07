package com.hug.socket.server.demo.integer;

import com.hug.socket.server.protocol.IntegerProtocol;
import org.smartboot.socket.transport.AioQuickServer;

import java.io.IOException;

/**
 * 启动服务端
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-05-07 17:52
 */
public class IntegerServer {
    public static void main(String[] args) throws IOException {
        AioQuickServer<Integer> server = new AioQuickServer<Integer>(18888, new IntegerProtocol(), new IntegerServerProcessor());
        server.start();
    }
}
