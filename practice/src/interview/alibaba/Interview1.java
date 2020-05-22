package interview.alibaba;

import java.util.Scanner;

/**
 * 阿里笔试 二分
 */
public class Interview1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int min_x = 100000;
        int max_x = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2; j ++) {
                int cur_x = sc.nextInt();
                if (j == 0) {
                    min_x = Math.min(min_x, cur_x);
                    max_x = Math.max(max_x, cur_x);
                    nums[i] = cur_x;
                }
            }
        }
        long ans = Long.MAX_VALUE;
//        for (int k = min_x; k <= max_x;  k ++) {
//            long cur_sum = getDistance(nums, k);
//            ans = Math.min(ans, cur_sum);
//        }
        int l = min_x, r = max_x;
        while (l < r) {
            int mid = l + r >> 1;
            long sum_mid = getDistance(nums, mid);
            long sum_mid_1 = getDistance(nums, mid - 1);
            if (sum_mid_1 > sum_mid) {
                ans = sum_mid;
                l = mid + 1;
            } else {
                ans = sum_mid_1;
                r = mid;
            }
        }
        System.out.println(ans);
    }
    private static long getDistance(int[] nums, int k) {
        long ret = 0;
        for (int i = 0; i < nums.length; i ++) {
            ret += (long)Math.abs(nums[i] - k);
        }
        return ret;
    }
}
