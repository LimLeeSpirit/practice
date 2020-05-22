package algorithm.A_排序;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 缺失的第一个正数。
 * 比如[3,4,-1,1] 输出 2
 *
 * [7,8,9,11,12] 输出: 1
 *
 * 时间复杂度O(n),空间O(1).
 */
public class H_leetcode41 {
    /**
     * 桶排序思路 https://www.acwing.com/solution/LeetCode/content/88/
     * 不用额外空间的桶排序：保证 1 出现在 nums[0] 的位置上，2 出现在 nums[1] 的位置上，…，
     * n出现在nums[n-1]的位置上，其他的数字不管。例如[3,4,-1,1]将被排序为[1,-1,3,4]
     *
     * 后来发现这个思想其实就是 将 1 - n 的数字放在下标为 0 - n-1 的位置上。n 为数组大小。
     * O（n）复杂度
     * @param nums nums
     * @return n
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i ++) {
            while (0 < nums[i] && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // swap(nums[i], nums[nums[i] - 1])
                int index = nums[i] - 1;
                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;
            }
        }

        for (int i = 0; i < n; i ++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }

    public static int firstMissingPositive2(int[] A) {
        /**
         *  果然温故而知新啊，第二次看的时候就能想到更好的逻辑了，虽然时间复杂度为O(nlgn),因为用到了排序
         *  但是逻辑很好理解呀哈哈。
         */
        if (A.length ==0) { return 1;}
        // 找出所有为正数的集合。
        List<Integer> pos = new ArrayList<>();
        pos.add(0);
        for (int a : A) {
            if (a > 0) {
                pos.add(a);
            }
        }

        Collections.sort(pos);

        if (pos.size() == 1) { return 1;}
        //在所有整数的排好序的 list 里不就就容易找了嘛
        for (int i = 1; i < pos.size(); i ++) {
            if (pos.get(i) - pos.get(i - 1) > 1) {
                return pos.get(i - 1) + 1;
            }
        }

        return pos.get(pos.size() - 1) + 1;
    }
}
