package basic.data.structure.stack.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wangxin
 * 2020/5/2 20:14
 * @since
 **/
class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;


    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.empty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.empty()) {
            return;
        }
        int temp = stack.pop();
        if (temp == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */