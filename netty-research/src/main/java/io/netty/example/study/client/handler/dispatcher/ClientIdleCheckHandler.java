package io.netty.example.study.client.handler.dispatcher;

import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * 业务端 idle 监测
 *
 * @author wangxin
 * 2020/12/26 23:29
 * @since
 **/
public class ClientIdleCheckHandler extends IdleStateHandler {
    public ClientIdleCheckHandler() {
        // 是否有 5s 的写空闲触发idle
        super(0, 5, 0, TimeUnit.SECONDS);
    }

}
