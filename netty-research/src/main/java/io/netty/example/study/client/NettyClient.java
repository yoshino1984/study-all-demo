package io.netty.example.study.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioChannelOption;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.example.study.common.RequestMessage;
import io.netty.example.study.common.order.OrderOperation;
import io.netty.example.study.client.codec.OrderFrameDecoder;
import io.netty.example.study.client.codec.OrderFrameEncoder;
import io.netty.example.study.client.codec.OrderProtocolDecoder;
import io.netty.example.study.client.codec.OrderProtocolEncoder;
import io.netty.example.study.util.IdUtil;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.util.concurrent.ExecutionException;

/**
 * @author wangxin
 * 2020/12/26 14:13
 * @since
 **/
public class NettyClient {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);

        bootstrap.option(NioChannelOption.CONNECT_TIMEOUT_MILLIS, 10 * 1000);

        NioEventLoopGroup group = new NioEventLoopGroup();

        try {
            bootstrap.group(group);
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();

                    pipeline.addLast("frameDecoder", new OrderFrameDecoder());
                    pipeline.addLast("frameEncoder", new OrderFrameEncoder());

                    pipeline.addLast("protocolDecoder", new OrderProtocolDecoder());
                    pipeline.addLast("protocolEncoder", new OrderProtocolEncoder());

                    pipeline.addLast(new LoggingHandler(LogLevel.INFO));
                }
            });
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8091);
            channelFuture.sync();

            OrderOperation operation = new OrderOperation(1984, "0712");
            // message 封装1
            RequestMessage requestMessage = new RequestMessage(IdUtil.nextId(), operation);
            System.out.println("isActive:" + channelFuture.channel().isActive());
            channelFuture.channel().writeAndFlush(requestMessage);

//            // message 封装2
//            channelFuture.channel().writeAndFlush(operation);

            Thread.sleep(1000);

            channelFuture.channel().closeFuture().sync();

        } finally {
            group.shutdownGracefully();
        }
    }
}
