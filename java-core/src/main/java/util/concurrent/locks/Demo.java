package util.concurrent.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {

    int count;

    public static void main(String[] args) throws InterruptedException {
        test3();
    }


    public static void test1() {
        Demo demo = new Demo();
        MyLock myLock = new MyLock();
        Runnable runnable = () -> {
            for (int i = 0; i < 100000; i++) {
                myLock.lock();
                demo.count++;
                myLock.unlock();
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(demo.count);
    }

    public static void test2() {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        condition.signal();
    }

    public static void test3() {
        LockSupport.unpark(Thread.currentThread());
        LockSupport.park();
        System.out.println("二元信号量，提前解锁了");
        LockSupport.park();
        System.out.println("二元信号量，爬");
    }
}
