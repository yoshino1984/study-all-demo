package resilience4j;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;

import java.time.Duration;

public class FuseDemo {

    public static void testCircuitBreaker() {
        BackendService backendService = new BackendService();

        CircuitBreakerConfig cfg = CircuitBreakerConfig.custom()
            //熔断器关闭情况下，记录请求状态的环形缓冲区大小，每次请求的成功失败状态在里面暂存占用一位。最近请求次数达到这个大小后计算是否需要触发断路判断;
            .slidingWindowSize(5)
            //半开状态下环形缓冲区大小，作用同上。默认为10
            .permittedNumberOfCallsInHalfOpenState(5)
            //熔断器关闭情况下，最近的几次请求里(次数等于slidingWindowSize)，失败率累计等于或大于这个百分比(如40%)时会打开(触发熔断);或在半开状态下，会重新熔断,若小于则恢复；
            .failureRateThreshold(50)
            //熔断器打开后，1毫秒后马上进入半开状态。测试时为了提高速度；实际默认值为1分钟
            .waitDurationInOpenState(Duration.ofMillis(2L))
            //慢请求阈值
            .slowCallDurationThreshold(Duration.ofMillis(500L))
            //达到慢请求的阈值后熔断
            .slowCallRateThreshold(60)
            .build();

        CircuitBreaker circuitBreaker = CircuitBreaker.of("backendName", cfg);
        // 可加入事件监听器
        CircuitBreakerListen.addCircuitBreakerListener(circuitBreaker);

        //测试效果，先成功，然后中间会出现一次异常断路保护，然后恢复，然后出现一次满请求断路保护，然后再恢复
        for (int ii = 0; ii < 60; ii++) {
            try {
                String result = circuitBreaker.executeSupplier(backendService::doSomething);
                //打印调用backendService成功消息
                System.out.println(result);
            } catch (CallNotPermittedException pe) {
                //打印断路保护器起作用后的消息
                System.out.println("断路保护拒绝访问:" + pe.getMessage());
            } catch (Throwable ex) {
                //打印调用backendService出错异常
                System.out.println(ex.getMessage());
            }
            // 额外打印断路器内部的状态信息，演示用。生成环境不需要。
            CircuitBreakerLocalUtil.getCircuitBreakerStatus(circuitBreaker);
        }
    }

    public static void main(String[] args) {
        testCircuitBreaker();
    }
}
