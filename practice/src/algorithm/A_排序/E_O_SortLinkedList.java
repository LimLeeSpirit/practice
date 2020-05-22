package algorithm.A_排序;


import algorithm.Aleetcode2_链表.ListNode;

/**
 * 对链表进行排序，要求时间复杂度为O（nlgn）
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * 时间复杂度暗示了利用归并排序
 */
public class E_O_SortLinkedList {
    public ListNode sortList(ListNode head) {
        // 递归终止条件：只有一个节点的时候就返回这个节点
        if (head == null || head.next == null)
            return head;

        // 先分
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 断开
        ListNode tmp = slow.next;
        slow.next = null;

        // 再治，分别进行排序
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode dummy = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return dummy.next;
    }
}
