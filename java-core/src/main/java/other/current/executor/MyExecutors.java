package other.current.executor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.lang.ref.Reference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wangxin
 * 2020/4/11 15:58
 * @since
 **/
@Slf4j
public class MyExecutors {

    static int queueSize = 10;
    private static ThreadPoolExecutor firstToMaxSizeThreadPool =
        new ThreadPoolExecutor(1, 5,
            60, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(queueSize) {
                @Override
                public boolean offer(Runnable runnable) {
                    return false;
                }
            },
            new ThreadFactoryBuilder().setNameFormat("demo-threadpool-%d").build(),
            new ThreadPoolExecutor.AbortPolicy() {
                @Override
                public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
                    System.out.println(e.getQueue().size());
                    if (e.getQueue().size() < queueSize) {
                        try {
                            e.getQueue().put(r);
                        } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                    } else {
                        System.out.println("register");
                        super.rejectedExecution(r, e);
                    }
                }
            }
        );

    private static ScheduledThreadPoolExecutor scheduledThreadPoolExecutor =
        new ScheduledThreadPoolExecutor(100);


    private static void printStats(ThreadPoolExecutor threadPool) {
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            log.info("=========================");
            log.info("Pool Size: {}", threadPool.getPoolSize());
            log.info("Active Threads: {}", threadPool.getActiveCount());
            log.info("Number of Tasks Completed: {}", threadPool.getCompletedTaskCount());
            log.info("Number of Tasks in Queue: {}", threadPool.getQueue().size());

            log.info("=========================");
        }, 0, 1, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws InterruptedException {
        String initialReference = "the initially referenced string";
        AtomicReference atomicStringReference = new AtomicReference(initialReference);

        String newReference = "new value referenced";
        boolean exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
        System.out.println("exchanged: " + exchanged);

        exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
        System.out.println("exchanged: " + exchanged);
    }


}
