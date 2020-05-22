package javadetail.basic.queue;

import java.util.*;

public class test {
    public static void main(String[] args) {
        // 普通队列
        Queue<Integer> q = new ArrayDeque<>();

        // 优先级队列，问你底层实现：Java中优先级队列就是小顶堆PriorityQueue，堆是一种能自我调整的完全二叉树，底层是由数组实现的
        Queue<Integer> heap = new PriorityQueue<>();

        // 双端队列都有哪些呢？实现了 Deque 接口的有 ArrayDeque，他是基于数组的双端队列，还有 LinkedList，他是基于链表的双端队列
        Deque<Integer> deq = new ArrayDeque<>();
        Deque<Integer> deque = new LinkedList<>();

        Object obj = new Object();

    }
}
