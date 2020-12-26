package basic.data.structure.queue.sample;

import com.google.common.primitives.Ints;

import java.util.stream.IntStream;

/**
 * 循环队列
 *
 * @author wangxin
 * 2020/5/3 10:30
 * @since
 **/
public class CircleQueue {
    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;


    public CircleQueue(int capacity) {
        // 循环队列实现时会有个空位，这里+1补足容量
        items = new String[capacity + 1];
        this.n = capacity + 1;
    }

    public boolean enqueue(String item) {
        if (isFull()) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    public String dequeue() {
        if (isEmpty()) {
            return null;
        }
        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return (head + n - tail) % n == 1;
    }

    public static void main(String[] args) {
        CircleQueue queue = new CircleQueue(3);
        IntStream.rangeClosed(1, 4).boxed()
            .forEach(i -> System.out.println(queue.enqueue(String.valueOf(i))));
        IntStream.rangeClosed(1, 4).boxed()
            .forEach(i -> System.out.println(queue.dequeue()));
    }
}
