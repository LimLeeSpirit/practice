package interview.others;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最长等差数列
 * 输入例子1:
 *
 * 5
 * 1 4 2 5 3
 *
 * 输出例子1:
 *
 * 5
 *
 * 肯定是用DP
 * DP[i][j] 代表从开始到i位置的最长等差数列长度，公差为 j
 *
 * DP[i]
 */
public class Interview23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] nums = new int[N];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i ++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
    }
}
