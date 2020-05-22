package algorithm.Aleetcode2_链表.leetcode445;


import algorithm.Aleetcode2_链表.ListNode;

import java.util.Stack;

/**
 * 2题 的升级版
 *
 * 我这里没有反转链表，而是使用的栈来保存，稍微慢了点
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        Stack<ListNode> stack3 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }

        while (l2!=null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        int carry = 0;
        int y;
        while ( !stack1.isEmpty() || !stack2.isEmpty() ) {
            int x1 = !stack1.isEmpty() ? stack1.pop().val : 0;
            int x2 = !stack2.isEmpty() ? stack2.pop().val : 0;
            y = (x1 + x2 + carry) % 10;
            carry = (x1 + x2 + carry) / 10;
            ListNode tmp = new ListNode(y);
            stack3.push(tmp);
        }

        if (carry > 0) {
            stack3.push(new ListNode(carry));
        }

        ListNode head = new ListNode(0);
        ListNode yummy = head;
        while (!stack3.isEmpty()) {
            head.next = stack3.pop();
            head = head.next;
        }

        return yummy.next;
    }
}

