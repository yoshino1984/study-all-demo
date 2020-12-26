package io.netty.example.study.server.codec;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * @author wangxin
 * 2020/12/26 13:40
 * @since
 **/
public class OrderFrameDecoder extends LengthFieldBasedFrameDecoder {
    public OrderFrameDecoder() {
        super(Integer.MAX_VALUE, 0, 2, 0, 2);
    }
}
