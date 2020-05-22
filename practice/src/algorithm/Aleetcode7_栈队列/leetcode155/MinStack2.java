package algorithm.Aleetcode7_栈队列.leetcode155;

import java.util.LinkedList;

/**
 * 设计一个栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 *
 * 这其实才是最好的
 *
 * 本题的本质其实就是开一个栈保存历史最小值，
 * 比如输入 -3 0 -2
 * 保存    -3 -3 -3
 *
 * stack1 维护一所有的值
 * stack2 是一个单调栈，大的在下面，小的在上面，一直保持最小值在上面
 */
class MinStack2 {
    private LinkedList<Integer> stack1;
    private LinkedList<Integer> stack2;


    public MinStack2() {
        this.stack1 = new LinkedList<>();
        this.stack2 = new LinkedList<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty()) {
            stack2.push(x);
        } else {
            if (stack2.peek() >= x) {
                stack2.push(x);
            }
        }
    }

    public void pop() {
        int tmp = stack1.pop();
        if (!stack2.isEmpty() && tmp == stack2.peek()) {
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}