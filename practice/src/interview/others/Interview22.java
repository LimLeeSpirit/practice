package interview.others;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 将数组分为两部分s1，s2，求｜s2的和 - s1的和｜最小值
 */
public class Interview22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] nums = new int[N];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i ++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        int[] pre_sums = new int[N];
        pre_sums[0] = nums[0];
        for (int i = 1; i < N; i ++) {
            pre_sums[i] = pre_sums[i - 1] + nums[i];
        }
        for (int j = 0; j < N; j ++) {
            ans = Math.min(ans, Math.abs(pre_sums[j] - (pre_sums[N - 1] - pre_sums[j])));
        }
        System.out.println(ans);
    }

    /**
     * 别人的AC代码
     */
    private static int diff = Integer.MAX_VALUE;

    public static void getMinDiff(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        dfs(nums, 0, 0, 0);
        System.out.println(diff);
    }

    private static void dfs(int[] nums, int level, int sum1, int sum2) {
        if (level == nums.length) {
            if (Math.abs(sum1 - sum2) < diff) {
                diff = Math.abs(sum1 - sum2);
            }
            return;
        }
        int temp = nums[level];
        dfs(nums, level + 1, sum1 + temp, sum2);
        dfs(nums, level + 1, sum1, sum2 + temp);
    }
}
