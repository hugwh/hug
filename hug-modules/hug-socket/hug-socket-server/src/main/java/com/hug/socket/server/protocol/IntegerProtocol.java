package com.hug.socket.server.protocol;

import org.smartboot.socket.Protocol;
import org.smartboot.socket.transport.AioSession;

import java.nio.ByteBuffer;

/**
 * 整数编解码协议
 * 一个整数的长度为4byte，所以只要长度大于等于4，我们就能解析到一个整数
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-05-07 17:47
 */
public class IntegerProtocol implements Protocol<Integer> {
    private static final int INT_LENGTH = 4;
    @Override
    public Integer decode(ByteBuffer byteBuffer, AioSession<Integer> aioSession) {
        if (byteBuffer.remaining() < INT_LENGTH)
            return null;
        return byteBuffer.getInt();
    }

    @Override
    public ByteBuffer encode(Integer integer, AioSession<Integer> aioSession) {
        ByteBuffer b = ByteBuffer.allocate(INT_LENGTH);
        b.putInt(integer);
        b.flip();
        return b;
    }
}
