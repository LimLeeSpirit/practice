package algorithm.Aleetcode7_栈队列.leetcode239;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *  滑动窗口的最大值：求出滑动窗口的最大值，每滑动一次，获取该窗口的最大值，保存到数组中
 *  经典的使用双端队列的题，上一个使用双端队列的还是ccf 那道字符串转数学表达式
 *
 *  为什么使用双端队列，不使用大顶堆呢，因为窗口是滑动的，前一个窗口的最大值也许就不在下一个窗口了
 *  利用双端队列保持一个包含最大元素下标的队列，因为是滑动的，所以保存下标是最好用的。
 *  最大元素维持在最左边。
 *
 *  注意双端队列的使用：
 *  如果指向null，会报异常 NoSuchElementException的方法：getFirst、getLast、addFirst、addLast、removerFirst、removeLast
 *                                      所以一般使用： peekFirst、peekLast、offerFirst、offerLast、pollFirst、pollLast
 */
public class Solution {

    // 算是单调队列最经典的题了吧，感觉这种动态求最值的，就得用到单调队列或者单调栈
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return new int[]{};

        Deque<Integer> q = new ArrayDeque<>();

        int[] ret = new int[n - k + 1];

        for (int i = 0; i < n; i ++) {
            // 如果左顶端下标不在当前窗口内了，删除
            if (!q.isEmpty() && i - k + 1 > q.peekFirst()) q.pollFirst();

            // 维持队列是从左到右单调减，最左端就是窗口最大的元素
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) q.pollLast();

            q.offerLast(i);
            // 如果 i 达到了窗口大小，则需要取值了
            if (i >= k - 1) ret[i - k + 1] = nums[q.peekFirst()];
        }
        return ret;
    }

}
