package algorithm.Aleetcode10_数组.数组或者字符串运算.leetcode15_数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找出所有三数之和为 0 的组合。是元素值了，不再是下标。
 * 常规做法：先对数组排序，再设置两个头尾指针，和一个顺序指针，共三个指针。头尾指针在最外层指针下进行查找。
 *
 * 四数之和：leetcode 18
 * 去重方法：
 *
 *
 * 好久不做居然差点不会啊！
 */
public class Solution2 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i ++) {
            // 最外层的去重方法
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = n - 1;
            while (l < r) {
                int tmp = nums[i] + nums[l] + nums[r];
                if (tmp == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // 内层的左指针去重方法，注意是一直到不重复，所以用while
                    while (l < r && nums[l] == nums[l + 1]) l ++;

                    // 内层的右指针去重方法，注意是一直到不重复，所以用while
                    while (l < r && nums[r] == nums[r - 1]) r --;
                    l ++;
                    r --;
                } else if (tmp > 0) r --;
                else l ++;

            }
        }
        return ans;
    }
}
