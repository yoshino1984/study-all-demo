package guava;

import com.google.common.util.concurrent.RateLimiter;

public class RatelimiterTest {


    public static void test() {
        RateLimiter rateLimiter = RateLimiter.create(0.1);
        for (int i = 0; i < 10; i++) {
            rateLimiter.acquire();
        }
    }

    public static void main(String[] args) {
        test();
    }
}
