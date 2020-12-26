package org.fenixsoft.clazz;

/**
 * @author wangxin
 * 2020/10/15 08:35
 * @since
 **/
public class TestClass {
    private int m;

    private static Integer s1 = 1;

    static {
        s1 = 2;
        s2 = 2;
    }

    private static Integer s2;


    public int inc(int out) {
        int a = 1;
        int b = 2;
        double c = a + b;
        if (a < out) {
            c = out;
            synchronized (Double.valueOf(c)) {
                for (int i = 0; i < c && out > b; i++) {
                    System.out.println(i);
                }
            }
        }
        return (int) c;
    }

    static class DeadLoopClass {
        static {
            // 如果不加上这个if语句，编译器将提示“Initializer does not complete normally” 并拒绝编译
            if (true) {
                System.out.println(Thread.currentThread() + "init DeadLoopClass");
                while (true) {
                }
            }
        }
    }

    public static void main(String[] args) {
        Runnable script = () -> {
            System.out.println(Thread.currentThread() + "start");
            DeadLoopClass dlc = new DeadLoopClass();
            System.out.println(Thread.currentThread() + " run over");
        };
        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);
        thread1.start();
        thread2.start();
    }
}
