package algorithm.Aleetcode2_链表.leetcode142;

import algorithm.Aleetcode2_链表.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 *  找出环形链表的入环节点
 *  法1：快慢指针：先找到环内相遇节点，再分别从头节点，相遇节点同时出发，这两个节点相遇的节点就是入环节点。
 *              后面一步的证明要会：
 *                  设 X 为没入环的链表长度， Y 为环的长度，Z为慢指针的路径长，则 2Z 为快指针的路径长，相差 Z 为环长。
 *  			    故 Z = Y；
 *  			    Y1 为快、慢指针在环内走入环的长度， Y2 为慢指针在环内剩下没走的长度
 *  			    故： Y1 + Y2 = Z = Y
 *  			    同时： Z = X + Y1
 *  			    故： X = Y2
 *  			    故新的两个指针一定可以在入网节点相遇
 *
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) { return null;}
        ListNode N1 = head;
        ListNode N2 = getMeetNode(head);
        if (N2 != null) {
            while (N1 != N2) {
                N1 = N1.next;
                N2 = N2.next;
            }
            return N1;
        }
        return null;
    }

    public ListNode getMeetNode(ListNode head) {
        ListNode low = head;
        ListNode fast = head;
        // 用到了 fast.next.next， 所以必须保证 fast.next 不为空
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
            if (fast == low) {
                return low;
            }
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        /**
         *  集合法
         */
        Set<ListNode> checked = new HashSet<>();
        ListNode N1 = head;

        while (N1 != null) {
            if (checked.contains(N1)) {
                return N1;
            }
            checked.add(N1);
            N1 = N1.next;
        }
        return null;
    }
}
