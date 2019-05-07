package com.hug.socket.server.demo.string;

import com.hug.socket.server.protocol.StringProtocol;
import org.smartboot.socket.MessageProcessor;
import org.smartboot.socket.StateMachineEnum;
import org.smartboot.socket.transport.AioQuickClient;
import org.smartboot.socket.transport.AioSession;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * 字符串socket客户端
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-05-07 18:39
 */
public class StringClientProcessor implements MessageProcessor<String> {
    private AioSession<String> session;

    @Override
    public void process(AioSession<String> session, String msg) {
        System.out.println("收到服务端消息：" + msg);
    }

    @Override
    public void stateEvent(AioSession<String> session, StateMachineEnum stateMachineEnum, Throwable throwable) {
        if (stateMachineEnum == StateMachineEnum.NEW_SESSION) {
            this.session = session;
        }
    }

    public AioSession<String> getSession() {
        return session;
    }

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        StringClientProcessor processor = new StringClientProcessor();
        AioQuickClient<String> client = new AioQuickClient<>("localhost", 28080, new StringProtocol(), processor);
        client.start();
        int i = 0;
        while (i++ < 10) {
            processor.getSession().write("Hello:" + i);
            Thread.sleep(1000);
        }
        client.shutdown();
    }
}
