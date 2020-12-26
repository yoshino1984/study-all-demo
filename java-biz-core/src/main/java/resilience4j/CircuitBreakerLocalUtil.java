package resilience4j;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;

public class CircuitBreakerLocalUtil {

    public static void getCircuitBreakerStatus(CircuitBreaker circuitBreaker){
        CircuitBreaker.Metrics metrics = circuitBreaker.getMetrics();
        float failureRate = metrics.getFailureRate();
        int bufferedCalls = metrics.getNumberOfBufferedCalls();
        int failedCalls = metrics.getNumberOfFailedCalls();
        int successCalls = metrics.getNumberOfSuccessfulCalls();
        long notPermittedCalls = metrics.getNumberOfNotPermittedCalls();
        long slowCalls = metrics.getNumberOfSlowCalls();
        System.out.println("state=" + circuitBreaker.getState() + " , metrics[ failureRate=" + failureRate +
            ", bufferedCalls=" + bufferedCalls +
            ", failedCalls=" + failedCalls +
            ", successCalls=" + successCalls +
            ", slowCalls=" + slowCalls +
            ", notPermittedCalls=" + notPermittedCalls +
            " ]"
        );
    }
}
