package interview.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 时间复杂度有点操了，O（n^2），不过我有剪支的呀，怎么还是不对
 */
public class Interview3 {
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i ++) {
            nums[i] = in.nextInt();
        }
        int[] ans = new int[N];
        Arrays.fill(ans, -1);
        visited = new boolean[N];
        for (int i = 0; i < N; i ++) {
            if (!visited[i]) {
                visited[i] = true;
                check(nums, i, ans);
            }
        }


        for (int i = 0; i < N - 1; i ++){
            System.out.printf(ans[i] + " ");
        }
        System.out.println(ans[N - 1]);
    }

    public static void check(int[] nums, int i, int[] ans) {
        for (int j = 0; j < nums.length; j ++) {
            if (visited[j])
            if (j != i) {
                if ((nums[i] & nums[j]) == 0) {
                    ans[i] = 1;
                    ans[j] = 1;
                    visited[j] = true;
                    return;
                }
            }
        }
    }
}
