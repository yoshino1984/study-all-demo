package io.netty.example.study.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioChannelOption;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.example.study.client.handler.dispatcher.ClientIdleCheckHandler;
import io.netty.example.study.client.handler.dispatcher.KeepaliveHandler;
import io.netty.example.study.common.RequestMessage;
import io.netty.example.study.common.auth.AuthOperation;
import io.netty.example.study.common.order.OrderOperation;
import io.netty.example.study.client.codec.OrderFrameDecoder;
import io.netty.example.study.client.codec.OrderFrameEncoder;
import io.netty.example.study.client.codec.OrderProtocolDecoder;
import io.netty.example.study.client.codec.OrderProtocolEncoder;
import io.netty.example.study.util.IdUtil;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;

/**
 * @author wangxin
 * 2020/12/26 14:13
 * @since
 **/
@Slf4j
public class NettyClient {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);

        bootstrap.option(NioChannelOption.CONNECT_TIMEOUT_MILLIS, 10 * 1000);

        NioEventLoopGroup group = new NioEventLoopGroup();

        try {

            KeepaliveHandler keepaliveHandler = new KeepaliveHandler();
            LoggingHandler loggingHandler = new LoggingHandler(LogLevel.INFO);


            bootstrap.group(group)
                .handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();

                    pipeline.addLast("idleCheckHandler", new ClientIdleCheckHandler())

                        .addLast("frameDecoder", new OrderFrameDecoder())
                        .addLast("frameEncoder", new OrderFrameEncoder())
                        .addLast("protocolDecoder", new OrderProtocolDecoder())
                        .addLast("protocolEncoder", new OrderProtocolEncoder())

                        .addLast("loggingHandler", loggingHandler)

                        .addLast("keepaliveHandler", keepaliveHandler);
                }
                });
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8091);
            channelFuture.sync();

            log.info("isActive:" + channelFuture.channel().isActive());
            // 首先发送 auth 请求，通过auth
            RequestMessage authRequest = new RequestMessage(IdUtil.nextId(), new AuthOperation("admin", "1234"));
            channelFuture.channel().writeAndFlush(authRequest);

            OrderOperation operation = new OrderOperation(1984, "0712");
            // message 封装1
            RequestMessage requestMessage = new RequestMessage(IdUtil.nextId(), operation);
            for (int i = 0; i < 20; i++) {
                channelFuture.channel().writeAndFlush(requestMessage);
            }

//            // message 封装2
//            channelFuture.channel().writeAndFlush(operation);

            Thread.sleep(1000);

            channelFuture.channel().closeFuture().sync();

        } finally {
            group.shutdownGracefully();
        }
    }
}
