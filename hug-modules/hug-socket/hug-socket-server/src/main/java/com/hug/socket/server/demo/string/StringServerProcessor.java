package com.hug.socket.server.demo.string;

import com.hug.socket.server.protocol.StringProtocol;
import org.smartboot.socket.MessageProcessor;
import org.smartboot.socket.StateMachineEnum;
import org.smartboot.socket.transport.AioQuickServer;
import org.smartboot.socket.transport.AioSession;

import java.io.IOException;

/**
 * 字符串socket服务端
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-05-07 18:37
 */
public class StringServerProcessor implements MessageProcessor<String> {
    @Override
    public void process(AioSession<String> aioSession, String s) {
        System.out.println("收到客户端消息:" + s);
        try {
            aioSession.write("服务端收到了你的消息:" + s);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void stateEvent(AioSession<String> aioSession, StateMachineEnum stateMachineEnum, Throwable throwable) {

    }

    public static void main(String[] args) throws IOException {
        AioQuickServer<String> server = new AioQuickServer<>(28080, new StringProtocol(), new StringServerProcessor());
        server.start();
    }
}
