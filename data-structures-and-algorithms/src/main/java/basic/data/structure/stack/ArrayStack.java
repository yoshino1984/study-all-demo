package basic.data.structure.stack;

import java.util.Objects;

/**
 * 顺序栈：数组实现
 * @author wangxin
 * 2020/5/2 16:40
 * @since
 **/
public class ArrayStack<T> {
    private T[] items;
    private int count;
    private int n;

    public ArrayStack(int n) {
        this.n = n;
        items = (T[]) new Object[n];
    }

    public boolean push(T item) {
        if (count == n) {
            return false;
        }
        items[count++] = item;
        return true;
    }

    public T pop() {
        if (count == 0) {
            return null;
        }
        count--;
        return items[count];
    }

}
