package interview.others;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Interview27 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, map.getOrDefault(1, 0) + 1);

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] work = new int[N];
        int[] gym = new int[N];
        for (int i = 0; i < N; i ++) {
            work[i] = in.nextInt();
        }
        for (int i = 0; i < N; i ++) {
            gym[i] = in.nextInt();
        }
        int[][] dp = new int[N + 1][3]; // dp[i][0],dp[i][1],dp[i][2] 分别代表第i天 休息/锻炼/工作的最小休息天数
        Arrays.fill(dp[0], 0);
        for (int i = 1; i <= N; i ++) {
            if (gym[i - 1] == 1) {
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]);
            }
            if (work[i - 1] == 1) {
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
            dp[i][0] = Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2])) + 1;
            System.out.println(dp[i][0]);
        }
        int ans = Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]));
        System.out.println(ans);
    }
}
