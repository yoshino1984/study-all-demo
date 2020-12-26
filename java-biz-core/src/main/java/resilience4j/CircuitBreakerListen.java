package resilience4j;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;

public class CircuitBreakerListen {
    public static void addCircuitBreakerListener(CircuitBreaker circuitBreaker){
        circuitBreaker.getEventPublisher()
            .onSuccess(event -> System.out.println("服务调用成功：" + event.toString()))
            .onError(event -> System.out.println("服务调用失败：" + event.toString()))
            .onIgnoredError(event -> System.out.println("服务调用失败，但异常被忽略：" + event.toString()))
            .onReset(event -> System.out.println("熔断器重置：" + event.toString()))
            .onStateTransition(event -> System.out.println("熔断器状态改变：" + event.toString()))
            .onCallNotPermitted(event -> System.out.println(" 熔断器已经打开：" + event.toString()))
        ;
    }
}
