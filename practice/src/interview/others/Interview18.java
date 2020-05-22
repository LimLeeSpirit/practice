package interview.others;

import java.util.*;

/**
 * 给出平面上点的坐标，求出斜率最大的两个点
 *
 * 其实很简单，按照 x 坐标排序，然后遍历一边得到结果，最大的斜率肯定出现在相邻两个坐标之间
 */
public class Interview18 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<int[]> pos = new ArrayList<>();
        List<int[]> ans = new ArrayList<>();
        double max = Double.MIN_VALUE;
        for (int i = 0; i < N; i ++) {
            int[] tmp = new int[2];
            for (int j = 0; j < 2; j ++) {
                tmp[j] = in.nextInt();
            }
            pos.add(tmp);
        }

        Collections.sort(pos, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int[] a : pos) {
            for (int b : a) {
                System.out.printf(b + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < N - 1; i ++) {
            double cur = (double) (pos.get(i + 1)[1] - pos.get(i)[1]) / (double) (pos.get(i + 1)[0] - pos.get(i)[0]);
            if (cur > max) {
                max = cur;
                ans.add(0, pos.get(i));
                ans.add(1, pos.get(i + 1));
            }
        }
        System.out.println("max: " + max);
        for (int[] a : ans) {
            for (int b : a) {
                System.out.printf(b + " ");
            }
            System.out.println();
        }
    }
}
