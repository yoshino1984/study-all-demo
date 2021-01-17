package com.yoshino.webflux;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
class WebFluxDemoApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("1");
    }



    @Test
    public void testFluxCreate() throws InterruptedException {
        Flux.just("Hello", "World").subscribe(System.out::println);
        Flux.fromArray(new Integer[] {1, 2, 3}).subscribe(System.out::println);
        Flux.empty().subscribe(System.out::println);
        Flux.range(1, 10).subscribe(System.out::println);
        Flux.interval(Duration.of(1, ChronoUnit.SECONDS)).subscribe(System.out::println);
        Flux.interval(Duration.ofMillis(1000)).subscribe(System.out::println);
        Thread.sleep(10000);
    }

    @Test
    public void testFlux() {
        Flux<Integer> integerFluxWithExp = Flux.just(1, 2)
            // 拼接一个异常
            .concatWith(Mono.error(new IllegalStateException()))
            .concatWith(Mono.error(new IllegalArgumentException()))
            // 常时重试1次
            .retry(1);

        integerFluxWithExp
            // 将异常转化为0
            .onErrorReturn(0)
            .subscribe(System.out::println);

        System.out.println("\n\n\n");

        integerFluxWithExp
            .onErrorResume(e -> {
                if (e instanceof IllegalStateException) {
                    return Mono.just(0);
                } else if (e instanceof IllegalArgumentException) {
                    return Mono.just(-1);
                }
                return Mono.empty();
            })
            .subscribe(System.out::println);


        System.out.println("\n\n\n测试异常消息打印");
        integerFluxWithExp.subscribe(System.out::println, System.err::println);


    }

    /**
     * 测试调度器
     */
    @Test
    public void testScheduler() throws InterruptedException {
        // 当前线程
        Schedulers.immediate().schedule(() -> System.out.println(Thread.currentThread().getName() + "-11"));
        System.out.println(Thread.currentThread().getName() + "-main");
        // 单线程
        Schedulers.single().schedule(() -> System.out.println(Thread.currentThread().getName() + "-11"));
        Schedulers.single().schedule(() -> System.out.println(Thread.currentThread().getName() + "-11"));
        // 重用单线程
        Scheduler scheduler = Schedulers.newSingle("renew");
        scheduler.schedule(() -> System.out.println(Thread.currentThread().getName() + "-11"));
        scheduler.schedule(() -> System.out.println(Thread.currentThread().getName() + "-11"));
        Thread.sleep(100);
        // 弹性线程池，
        Set<String> elasticThreadNames = new ConcurrentSkipListSet<>();
        for (int i = 0; i < 100; i++) {
            Schedulers.elastic().schedule(() -> elasticThreadNames.add(Thread.currentThread().getName()));
        }
        System.out.println("Schedulers.elastic()  size:" + elasticThreadNames.size());

        Set<String> elasticThreadNames2 = new ConcurrentSkipListSet<>();
        for (int i = 0; i < 100; i++) {
            Schedulers.boundedElastic().schedule(() -> elasticThreadNames2.add(Thread.currentThread().getName()));
        }
        System.out.println("Schedulers.boundedElastic()  size:" + elasticThreadNames2.size());

        // 基于线程池的调度器
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Schedulers.fromExecutorService(executorService).schedule(() -> {
            System.out.println(Thread.currentThread().getName() + "-" + 11);
        });


        // 指定调度器，每100ms 打印一次，默认 parallel
        // single模式 Flux.interval(Duration.ofMillis(100), Schedulers.newSingle("test"))
        Flux<String> intervalResult = Flux.interval(Duration.ofMillis(100))
            .map(i -> Thread.currentThread().getName() + "@" + i);
        intervalResult.subscribe(System.out::println);

        Thread.sleep(10000);
    }


    /**
     *
     */
    @Test
    public void testPublishOnAndSubscribeOn() {
        Flux.create(sink -> {
            sink.next(Thread.currentThread().getName());
            sink.complete();
        })
            /* publishOn 的用法和处于订阅链（subscriber chain）中的其他操作符一样。
              它将上游信号传给下游，同时执行指定的调度器 Scheduler 的某个工作线程上的回调。
              它会改变后续的操作符的执行所在线程 （直到下一个 publishOn 出现在这个链上） */
            .publishOn(Schedulers.single())
            .map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
            .publishOn(Schedulers.elastic())
            .map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
            .subscribeOn(Schedulers.parallel())
            .toStream()
            .forEach(System.out::println);


    }

}
