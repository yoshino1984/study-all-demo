package com.yoshino.webflux.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author wangxin
 **/
@RestController
@RequestMapping("/api/")
@Slf4j
public class HelloController {

    @GetMapping("mono")
    public Mono<Object> mono() {
        // mono发送一个数据
        return Mono.create(monoSink -> {
            log.info("创建 Mono");
            monoSink.success("hello webflux");
        })
            .doOnSubscribe(subscription -> {
                //当订阅者去订阅发布者的时候，该方法会调用
                log.info("{}", subscription);
            }).doOnNext(o -> {
                //当订阅者收到数据时，改方法会调用
                log.info("{}", o);
            });
    }

    @GetMapping("flux")
    public Flux<String> flux() {
        // flux 支持发射多个数据
        return Flux.just("hello ", "World", "!");
    }

}
