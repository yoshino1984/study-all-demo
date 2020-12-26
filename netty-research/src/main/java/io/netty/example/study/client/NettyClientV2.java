package io.netty.example.study.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.example.study.client.codec.OrderFrameDecoder;
import io.netty.example.study.client.codec.OrderFrameEncoder;
import io.netty.example.study.client.codec.OrderProtocolDecoder;
import io.netty.example.study.client.codec.OrderProtocolEncoder;
import io.netty.example.study.client.handler.dispatcher.OperationResultFuture;
import io.netty.example.study.client.handler.dispatcher.RequestPendingCenter;
import io.netty.example.study.client.handler.dispatcher.ResponseDispatcherHandler;
import io.netty.example.study.common.OperationResult;
import io.netty.example.study.common.RequestMessage;
import io.netty.example.study.common.order.OrderOperation;
import io.netty.example.study.util.IdUtil;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.util.concurrent.ExecutionException;

/**
 * @author wangxin
 * 2020/12/26 14:13
 * @since
 **/
public class NettyClientV2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);

        NioEventLoopGroup group = new NioEventLoopGroup();

        RequestPendingCenter requestPendingCenter = new RequestPendingCenter();
        ResponseDispatcherHandler responseDispatcherHandler = new ResponseDispatcherHandler(requestPendingCenter);

        try {
            bootstrap.group(group);
            bootstrap.handler(new ChannelInitializer<NioSocketChannel>() {
                @Override
                protected void initChannel(NioSocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();
                    pipeline.addLast("frameDecoder", new OrderFrameDecoder());
                    pipeline.addLast("frameEncoder", new OrderFrameEncoder());

                    pipeline.addLast("protocolDecoder", new OrderProtocolDecoder());
                    pipeline.addLast("protocolEncoder", new OrderProtocolEncoder());

                    pipeline.addLast(responseDispatcherHandler);

                    pipeline.addLast(new LoggingHandler(LogLevel.INFO));
                }
            });
            ChannelFuture channelFuture = bootstrap.connect("localhost", 8091).sync();

            OrderOperation operation = new OrderOperation(1984, "0712");
            long streamId = IdUtil.nextId();
            RequestMessage requestMessage = new RequestMessage(streamId, operation);

            OperationResultFuture operationResultFuture = new OperationResultFuture();
            requestPendingCenter.add(streamId, operationResultFuture);

            channelFuture.channel().writeAndFlush(requestMessage);

            OperationResult operationResult = operationResultFuture.get();
            System.out.println(operationResult);

            channelFuture.channel().closeFuture().sync();

        } finally {
            group.shutdownGracefully();
        }
    }
}
