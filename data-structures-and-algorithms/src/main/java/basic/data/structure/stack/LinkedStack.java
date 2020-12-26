package basic.data.structure.stack;

import basic.common.ListNode;

import java.util.LinkedList;

/**
 * 链式栈：链表实现
 * @author wangxin
 * 2020/5/2 16:40
 * @since
 **/
public class LinkedStack<T> {
    public LinkedList<T> items;

    public LinkedStack() {
        items = new LinkedList<>();
    }

    public boolean push(T item) {
        items.push(item);
        return true;
    }

    public T pop() {
        if (items.isEmpty()) {
            return null;
        }
        return items.pop();
    }

}
