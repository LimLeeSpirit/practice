package algorithm.Aleetcode2_链表.leetcode92;


import algorithm.Aleetcode2_链表.ListNode;

/**
 * 反转链表II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 */
public class Solution {
    /**
     *  哈哈哈，后面做这类题，简直是有点so easy 的感觉，链表的题就是要好好思考，需要找到什么特定的点，需不需要设置虚拟头节点
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        int cnt = 1;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // pre 是开始转的节点的前一个节点
        ListNode pre = dummy;
        while (cnt < m) {
            pre = pre.next;
            cnt ++;
        }

        cnt = 0;
        int len = n - m;
        // 针对需要旋转的，进行反转，
        ListNode cur = pre.next;
        while (cur != null && cur.next != null && cnt < len) {
            ListNode second = cur.next;

            cur.next = second.next;
            second.next = pre.next;
            pre.next = second;

            cnt ++;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode tmp = new ListNode(1);
        ListNode head = tmp;
        for (int i=2; i<6; i++) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }
        ListNode head2 = reverseBetween(head, 1,3);
        while (head2 != null) {
            System.out.print(head2.val + " ");
            head2 = head2.next;
        }
    }
}
