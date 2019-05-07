package com.hug.socket.server.protocol;

import org.smartboot.socket.Protocol;
import org.smartboot.socket.transport.AioSession;

import java.nio.ByteBuffer;

/**
 * 字符串编解码协议
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-05-07 18:36
 */
public class StringProtocol implements Protocol<String> {
    private static final int INT_LENGTH = 4;

    @Override
    public String decode(ByteBuffer byteBuffer, AioSession<String> aioSession) {
        //识别消息长度
        if (byteBuffer.remaining() < INT_LENGTH) {
            return null;
        }
        //判断是否存在半包情况
        int len = byteBuffer.getInt(0);
        if (byteBuffer.remaining() < len) {
            return null;
        }
        byteBuffer.getInt();//跳过length字段
        byte[] bytes = new byte[len - INT_LENGTH];
        byteBuffer.get(bytes);
        return new String(bytes);
    }

    @Override
    public ByteBuffer encode(String s, AioSession<String> aioSession) {
        byte[] bytes = s.getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(INT_LENGTH + bytes.length);
        buffer.putInt(INT_LENGTH + bytes.length);
        buffer.put(bytes);
        buffer.flip();
        return buffer;
    }
}
