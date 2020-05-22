package algorithm.Aleetcode7_栈队列;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *  利用队列实现栈
 *
 *  哈哈第三次画个图就出来了，利用队列实现栈需要随时更新头元素，所以需要在两个队列之间来回捣鼓，把数据只存放在
 *  一个队列中，当新元素进来时候，先放在那个空队列里，再将另一个队列的所有元素移过来。
 *
 */
public class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    /** Initialize your data structure here. */
    public MyStack() {
        q2 = new ArrayDeque<>();
        q1 = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (q1.isEmpty()) {
            q1.offer(x);
            while (!q2.isEmpty()) q1.offer(q2.poll());
        } else {
            q2.offer(x);
            while (!q1.isEmpty()) q2.offer(q1.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (q1.isEmpty()) return q2.poll();
        return q1.poll();
    }

    /** Get the top element. */
    public int top() {
        if (q1.isEmpty()) return q2.peek();
        return q1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
