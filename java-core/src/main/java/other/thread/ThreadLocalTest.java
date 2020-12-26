package other.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author wangxin
 * 2020/5/4 16:31
 * @since
 **/
public class ThreadLocalTest {

    private final static ThreadLocal<Map<String, String>> localMap = ThreadLocal.withInitial(() -> {
        Map<String, String> map = new HashMap<>();
        map.put(Thread.currentThread().getName(), "value");
        return map;
    });

    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println(localMap.get());
        new Thread(runnable, "name1").start();
        new Thread(runnable, "name2").start();
        new Thread(runnable, "name3").start();
        runnable.run();

        Integer a = 1;
        Integer b = 2;
        Integer c = null;
        Boolean flag = false;
        // a*b 的结果是 int 类型，那么 c 会强制拆箱成 int 类型，抛出 NPE 异常
//        Integer result=(flag? a*b : c);


    }

}

