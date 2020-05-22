package algorithm.Aleetcode2_链表.leetcode148;

import algorithm.Aleetcode2_链表.ListNode;

/**
 *  使用归并排序对链表进行排序。在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *  这里使用的归并，其实空间用了O（n），要达到O（1）需要用快排
 *
 *  分割 cut 环节： 找到当前链表中点，并从中点将链表断开（以便在下次递归 cut 时，链表片段拥有正确边界）；
 *  我们使用 fast,slow 快慢双指针法，奇数个节点找到中点，偶数个节点找到中心左边的节点。
 *  找到中点 slow 后，执行 slow.next = None 将链表切断。
 *
 *  递归分割时，输入当前链表左端点 head 和中心节点 slow 的下一个节点 tmp(因为链表是从 slow 切断的)。
 *
 *  cut 递归终止条件： 当head.next == None时，说明只有一个节点了，直接返回此节点。
 *
 *
 *  合并 merge 环节： 将两个排序链表合并，转化为一个排序链表。
 *  双指针法合并，建立辅助 ListNode h 作为头部。
 *
 *  设置两指针 left, right 分别指向两链表头部，比较两指针处节点值大小，由小到大加入合并链表头部，指针交替前进，直至添加完两个链表。
 *  返回辅助 ListNode h 作为头部的下个节点 h.next。
 *
 *
 *  这个真的有点不太擅长啊。。。
 *
 *
 *  第二次做的时候发现还是挺好做的，就是从合并两个有序链表开始想的。将长链表划分为子链表，有点归并的意思，先将短链表排序，再将有序长链表合并。
 *  时间复杂度O(nlgn)，空间复杂度O(lgn),因为是递归，所有会申请虚拟机栈的深度。
 *
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        // fast 从第二个节点走，是为了更居中切断
        ListNode fast = head.next;
        ListNode slow = head;
        // 这个条件容易漏
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 先分
        ListNode tmp = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        ListNode h = new ListNode(-1);
        ListNode dummy = h;

        // 再治理
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

        h.next = left == null ? right : left;
        return dummy.next;
    }

    // 只有非递归版才会满足条件，空间复杂度是O（1），时间复杂度是O（nlgn）
    // 这是用了自底向上的方法，将链表划分为偶数段，但是太难想了。
    public ListNode sortList2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        int n = 0;
        for (ListNode tmp = head; tmp != null; tmp = tmp.next) n++;

        // 分为小段
        for (int i = 1; i < n; i *= 2) {
            ListNode cur = dummy;
            for (int j = 0; j + i < n; j += i * 2) {
                ListNode left = cur.next, right = cur.next;
                for (int k = 0; k < i; k++) right = right.next;
                int l = 0, r = 0;
                while (l<i && r < i && right != null) {
                    if (left.val <= right.val) {
                        cur.next = left;
                        cur = left;
                        left = left.next;
                        l ++;
                    } else {
                        cur.next = right;
                        cur = right;
                        right = right.next;
                        r ++;
                    }
                }

                while(l < i) {
                    cur.next = left;
                    cur = left;
                    left = left.next;
                    l ++;
                }

                while (r < i && right != null) {
                    cur.next = right;
                    cur = right;
                    right = right.next;
                    r ++;
                }
                cur.next = right;
            }
        }
        return dummy.next;
    }
}

