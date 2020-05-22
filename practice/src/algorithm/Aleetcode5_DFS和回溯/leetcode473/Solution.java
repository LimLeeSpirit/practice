package algorithm.Aleetcode5_DFS和回溯.leetcode473;

import java.util.Arrays;

/**
 * 火柴拼成正方形
 *
 * 输入为火柴数组，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
 *
 * 输入: [1,1,2,2,2]
 * 输出: true
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 *
 * 输入: [3,3,3,3,4]
 * 输出: false
 * 解释: 不能用所有火柴拼成一个正方形。
 *
 * 这道题要怎么思考呢，跟着y总来做一遍之后，发现世界都清晰了！要拼成正方形，说白了就是要将数组划分为4个和值相同的部分
 *      利用深度搜索 依次构造每条边
 *      所以 dfs 参数有 u 当前边、cur 当前边的和，在dfs内部对火柴进行遍历，所以还需要一个
 *      标记数组进行判断是否用过这根火柴。
 *
 * 而且这道题是回溯剪支的终极案例，共有4个地方用到了剪支：
 * 1、将火柴按照 从大到小 的顺序进行遍历，整个边的选取的可能性是固定的，只是顺序不一样，
 *      首先枚举分支少的，这样在剪支的时候，就把剩下的更多的分支给剪掉了，从长火柴开始遍历，边的长度是固定的，
 *      自然其分支就少了。
 * 2、若正在枚举的是某条边的第一根火柴，且失败了，则直接返回false，因为以此火柴为首的边注定拼接失败，可以反证法证明
 * 3、若正在枚举的是某条边的最后一个火柴，且失败了，则直接返回false，因为以此火柴为首的边注定拼接失败，可以反证法证明
 * 4、若针对某一条边，拼接失败了，当前火柴和下一根火柴相等长度，则跳过
 *
 */
class Solution {
    boolean[] v;
    int n;
    int sum;
    public boolean makesquare(int[] nums) {
        n = nums.length;
        v = new boolean[n];
        sum = 0;

        // 从大到小的顺序遍历
        Arrays.sort(nums);
        reverse(nums);

        // 如果不满足4条边相同，直接false
        for (int a : nums) sum += a;
        if (sum == 0 || sum % 4 != 0) return false;

        // 进行深度搜索
        return dfs(nums, 0, 0, sum/4);
    }

    private void reverse(int[] nums) {
        for (int i = 0, j = nums.length - 1; i < j; i ++, j --) {
            int tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
        }
    }

    /**
     * @param nums 火柴长度数组
     * @param u    当前拼的是第几条边
     * @param cur  当前拼的边的长度和
     * @param length 每条边的长度
     * @return     当前边是否拼成功
     */
    private boolean dfs(int[] nums, int u, int cur, int length) {
        if (cur == length) {
            u ++;
            cur = 0;
        }
        if (u == 4) return true;

        for (int i = 0; i < n; i ++) {
            if (!v[i] && cur + nums[i] <= length) {
                v[i] = true;

                if (dfs(nums, u, cur + nums[i], length)) return true;

                // 失败回溯
                v[i] = false;
                // 剪支操作
                if (i == 0) return false;
                if (cur + nums[i] == length) return false;
                while (i + 1 < n && nums[i] == nums[i + 1]) i ++;
            }
        }

        return false;
    }
}
