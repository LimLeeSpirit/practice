package interview.tencent;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Interview2 {
    public static DecimalFormat decimalFormat = new DecimalFormat("0.000");
    public static void main(String[] args) {
//        System.out.println(decimalFormat.format(0));
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i ++) {
            int k = in.nextInt();
            int[][] A = new int[k][2];
            int[][] B = new int[k][2];
            for (int j = 0; j < k;j ++) {
                A[j][0] = in.nextInt();
                A[j][1] = in.nextInt();
            }
            for (int j = 0; j < k;j ++) {
                B[j][0] = in.nextInt();
                B[j][1] = in.nextInt();
            }
            System.out.println(decimalFormat.format(getMinDist(k, A, B)));
        }
    }

    public static double getMinDist(int k, int[][] A, int[][] B) {
        double ans = Double.MAX_VALUE;
        for (int i = 0; i < k; i ++) {
            for (int j = 0; j < k; j ++) {
                double cur = posDistance(A[i][0], A[i][1], B[j][0], B[j][1]);
                if (ans > cur) {
                    ans = cur;
                }
            }
        }
        return ans;
    }

    public static double posDistance(int x1, int y1, int x2, int y2) {
        int a = Math.abs(x1 - x2);
        int b = Math.abs(y1 - y2);
//        System.out.println("a:" + a);
//        System.out.println("b:" + b);
//        System.out.println("pos di:" + Math.sqrt(a * a + b * b));
        return Math.sqrt(a * a + b * b);
    }
}
