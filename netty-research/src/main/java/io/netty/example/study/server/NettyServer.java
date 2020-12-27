package io.netty.example.study.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioChannelOption;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.example.study.server.codec.OrderFrameDecoder;
import io.netty.example.study.server.codec.OrderFrameEncoder;
import io.netty.example.study.server.codec.OrderProtocolDecoder;
import io.netty.example.study.server.codec.OrderProtocolEncoder;
import io.netty.example.study.server.handler.AuthHandler;
import io.netty.example.study.server.handler.MetricHandler;
import io.netty.example.study.server.handler.OrderServerProcessHandler;
import io.netty.example.study.server.handler.ServerIdleCheckHandler;
import io.netty.handler.flush.FlushConsolidationHandler;
import io.netty.handler.ipfilter.IpFilterRuleType;
import io.netty.handler.ipfilter.IpSubnetFilterRule;
import io.netty.handler.ipfilter.RuleBasedIpFilter;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.traffic.GlobalTrafficShapingHandler;
import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.concurrent.UnorderedThreadPoolEventExecutor;

import java.util.concurrent.ExecutionException;

/**
 * @author wangxin
 * 2020/12/26 13:58
 * @since
 **/
public class NettyServer {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        serverBootstrap.channel(NioServerSocketChannel.class);
        // 最大的等待的连接数量
        serverBootstrap.option(NioChannelOption.SO_BACKLOG, 1024);
        // 是否禁用Nagle算法：用来将小的碎片数据连接成更大的报文
        serverBootstrap.childOption(NioChannelOption.TCP_NODELAY, true);
        serverBootstrap.handler(new LoggingHandler(LogLevel.INFO));

        // thread
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(0, new DefaultThreadFactory("boss"));
        NioEventLoopGroup workGroup = new NioEventLoopGroup(0, new DefaultThreadFactory("worker"));
        // 使用额外的线程池来处理IO密集型的处理，提升性能
        UnorderedThreadPoolEventExecutor businessGroup = new UnorderedThreadPoolEventExecutor(10, new DefaultThreadFactory("business"));
        NioEventLoopGroup eventLoopGroupForTrafficShaping = new NioEventLoopGroup(0, new DefaultThreadFactory("TS"));

        try {
            // 日志
            ChannelHandler infoLogHandler = new LoggingHandler(LogLevel.INFO);
            // trafficShaping 流量整型配置（应用场景比较不好控制，设置的太大则等于无效，太小则容易误伤）
            ChannelHandler globalTrafficShapingHandler = new GlobalTrafficShapingHandler(eventLoopGroupForTrafficShaping, 10 * 1024 * 1024, 10 * 1024 * 1024);
            // 监控
            MetricHandler metricHandler = new MetricHandler();

            // ip filter（CIDR 的位数，以及直接拒绝或者允许）
            IpSubnetFilterRule ipSubnetFilterRule = new IpSubnetFilterRule("127.1.1.1", 16, IpFilterRuleType.REJECT);
            RuleBasedIpFilter ruleBasedIpFilter = new RuleBasedIpFilter(ipSubnetFilterRule);
            // 授权处理
            AuthHandler authHandler = new AuthHandler();

            serverBootstrap.group(bossGroup, workGroup)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                @Override
                protected void initChannel(NioSocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();


                    pipeline.addLast("ipFilter", ruleBasedIpFilter);

                    pipeline.addLast("tsHandler", globalTrafficShapingHandler);

                    pipeline.addLast("idleCheckHandler", new ServerIdleCheckHandler());

                    pipeline.addLast("metricHandler", metricHandler);

                    pipeline.addLast("frameDecoder", new OrderFrameDecoder());
                    pipeline.addLast("frameEncoder", new OrderFrameEncoder());

                    pipeline.addLast("protocolDecoder", new OrderProtocolDecoder());
                    pipeline.addLast("protocolEncoder", new OrderProtocolEncoder());

                    pipeline.addLast("infoLog", infoLogHandler);

                    /*
                    * 增强写，在延迟与吞吐量做平衡的设置
                    * 比如当前配置的含义为 每5次write触发一次flush，并且支持 异步IO 的情况
                    */
                    pipeline.addLast("flushEnhance", new FlushConsolidationHandler(5, true));

                    pipeline.addLast("authHandler", authHandler);

                    pipeline.addLast(businessGroup, "orderProcess", new OrderServerProcessHandler());
                }
            });

            ChannelFuture future = serverBootstrap.bind(8091);

            future.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
