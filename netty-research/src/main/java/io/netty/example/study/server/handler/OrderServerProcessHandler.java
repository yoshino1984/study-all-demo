package io.netty.example.study.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.example.study.common.Operation;
import io.netty.example.study.common.OperationResult;
import io.netty.example.study.common.RequestMessage;
import io.netty.example.study.common.ResponseMessage;


/**
 * @author wangxin
 * 2020/12/26 13:50
 * @since
 **/
public class OrderServerProcessHandler extends SimpleChannelInboundHandler<RequestMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RequestMessage requestMessage) throws Exception {
        Operation operation = requestMessage.getMessageBody();
        OperationResult operationResult = operation.execute();

        ResponseMessage responsemessage = new ResponseMessage();
        responsemessage.setMessageHeader(requestMessage.getMessageHeader());
        responsemessage.setMessageBody(operationResult);

        ctx.writeAndFlush(responsemessage);
//        if (ctx.channel().isActive() && ctx.channel().isWritable()) {
//        } else {
//            System.out.println("not writable now, message dropped");
//        }
    }
}
