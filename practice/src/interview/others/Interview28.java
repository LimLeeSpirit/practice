package interview.others;

import java.util.*;

/**
 * 输入描述:
 *
 * 输入包括n+1行。
 *
 * 第一行包括两个正整数n和L(1<=n<=105,1<=L<=109)
 *
 * 接下来的n行,每行两个正整数xi,yi(0<=xi<=yi<=109),表示第i个真视守卫覆盖的区间。
 * 输出描述:
 *
 * 一个整数，表示最少需要的真视守卫数量, 如果无解, 输出-1。
 *
 * 输入例子1:
 *
 * 4 6
 * 3 6
 * 2 4
 * 0 2
 * 4 7
 *
 * 输出例子1:
 *
 * 3
 * 解释：0，2   2，4   4，6
 *
 * 原来是贪心策略
 */
public class Interview28 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int L = in.nextInt();
        List<int[]> pos = new ArrayList<>();
        for (int i = 0; i < N; i ++ ) {
            int x = in.nextInt();
            int y = in.nextInt();
            pos.add(new int[]{x, y});
        }
        Collections.sort(pos, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        if (pos.get(0)[0] > 0 || pos.get(N - 1)[1] < L) {
            System.out.println(-1);
            return;
        }
        //
        int ans = 0;
        int left = 0; // 找出左边界<=0的所有区间里，右边界最大的，把left更新，直到left达到L
        // 只要思路对了，居然能一次成功！
        int idx = 0;
        int right = 0;
        while (left < L) {
            boolean is_gap = true;
            while (idx < N && pos.get(idx)[0] <= left) {
                is_gap = false;
                if (pos.get(idx)[1] > right) {
                    right = pos.get(idx)[1];
                }
                idx ++;
            }
            if (is_gap) {
                System.out.println(-1);
                return;
            }
            left = right;
            ans ++;
        }
        System.out.println(ans);
    }
}
