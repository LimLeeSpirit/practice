package algorithm.Aleetcode7_栈队列.leetcode155;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * 设计一个栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 *
 *
 * 我这里是用的小顶堆来实现的 PriorityQueue。将每次加入的元素，也加入小顶堆，可以实现常数时间获取最小值。
 *
 */
public class MinStack {
    private Queue<Integer> minHeap;
    private Stack<Integer> stack;

    public MinStack() {
        this.minHeap = new PriorityQueue<>();
        this.stack = new Stack<>();
    }

    public void push(int x) {
        this.minHeap.offer(x);
        this.stack.push(x);
    }

    public void pop() {
        int x = this.stack.pop();
        this.minHeap.remove(x);
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        return this.minHeap.peek();
    }

    public static void main(String[] args) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(4);
        minHeap.offer(1);
        minHeap.offer(3);
        minHeap.offer(33);
        minHeap.offer(-1);
        // 可以删除具体元素，添加具体元素，获取堆顶元素是常数时间，添加元素是O(nlgn)。
        while ( !minHeap.isEmpty() ) {
            System.out.println(minHeap.poll());
        }
    }
}
