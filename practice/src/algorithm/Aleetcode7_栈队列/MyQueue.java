package algorithm.Aleetcode7_栈队列;

import java.util.LinkedList;

/**
 *  利用两个栈实现一个队列
 *  可恶啊，这么简单的逻辑在面试的时候没有想写出来
 *  不就是一个栈用来存 push 进来的，一个用来存 pop 和 需要取 peek 的嘛，如果要pop，stack2有元素，则直接pop，否则，将
 *  stack1 的所有元素逆序存入stack2，再进行pop。stack1和stack2共同存储元素，一个存，一个出，这种思想应该想到的
 *  还是紧张了。
 *
 *
 *  用栈实现队列，就是一个存，一个出，是最高效的。
 *
 *  注意不要和 2个队列实现一个栈搞混了，由于栈需要实时获取栈顶元素，所以两个队列需要在put的时候来回捣鼓，效率较低
 */
public class MyQueue {
    LinkedList<Integer> stk1;
    LinkedList<Integer> stk2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stk1 = new LinkedList<>();
        stk2 = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stk1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!stk2.isEmpty()) return stk2.pop();
        while (!stk1.isEmpty()) stk2.push(stk1.pop());
        return stk2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (!stk2.isEmpty()) return stk2.peek();
        while (!stk1.isEmpty()) stk2.push(stk1.pop());
        return stk2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stk1.isEmpty() && stk2.isEmpty();
    }
}
