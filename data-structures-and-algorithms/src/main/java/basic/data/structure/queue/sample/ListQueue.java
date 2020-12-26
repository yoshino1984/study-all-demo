package basic.data.structure.queue.sample;

import basic.common.ListNode;

import java.util.stream.IntStream;

/**
 * 链式队列
 *
 * @author wangxin
 * 2020/5/3 10:44
 * @since
 **/
public class ListQueue {

    private Node head;
    private Node tail;

    public ListQueue() {
        head = new Node("");
        tail = head;
    }

    public static class Node {
        String val;
        public Node next;

        public Node(String x) {
            val = x;
        }
    }

    public boolean enqueue(String item) {
        tail.next = new Node(item);
        tail = tail.next;
        return true;
    }

    public String dequeue() {
        if (isEmpty()) {
            return null;
        }
        Node ret = head.next;
        if (tail == ret) {
            head.next = null;
            tail = head;
        } else {
            head.next = head.next.next;
        }
        return ret.val;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public static void main(String[] args) {
        ListQueue queue = new ListQueue();
        IntStream.rangeClosed(1, 4).boxed()
            .forEach(i -> System.out.println(queue.enqueue(String.valueOf(i))));
        IntStream.rangeClosed(1, 3).boxed()
            .forEach(i -> System.out.println(queue.dequeue()));
        IntStream.rangeClosed(5, 8).boxed()
            .forEach(i -> System.out.println(queue.enqueue(String.valueOf(i))));
        IntStream.rangeClosed(1, 6).boxed()
            .forEach(i -> System.out.println(queue.dequeue()));
    }
}
