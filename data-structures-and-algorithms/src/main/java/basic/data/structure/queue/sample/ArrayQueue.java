package basic.data.structure.queue.sample;

/**
 * 顺序队列（数组）
 * 2020/5/3 10:21
 * @since
 **/
public class ArrayQueue {
    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        this.n = capacity;
    }

    public boolean enqueue(String item) {
        if (tail == n) {
            // 如果队列未满，则进行数据搬移
            if (head == n) {
                return false;
            }
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        items[tail++] = item;
        return true;
    }

    public String dequeue() {
        if (head == tail) {
            return null;
        }
        return items[head++];
    }
}
