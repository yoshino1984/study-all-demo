package io.netty.example.study.client.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.example.study.common.Operation;
import io.netty.example.study.common.RequestMessage;
import io.netty.example.study.util.IdUtil;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * @author wangxin
 * 2020/12/26 14:24
 * @since
 **/
public class OperationToRequestMessageEncoder extends MessageToMessageEncoder<Operation> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Operation operation, List<Object> out) throws Exception {
        out.add(new RequestMessage(IdUtil.nextId(), operation));
    }
}
