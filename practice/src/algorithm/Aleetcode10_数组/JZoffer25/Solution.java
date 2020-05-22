package algorithm.Aleetcode10_数组.JZoffer25;

/**
 * 给你一根长度为 n 绳子，请把绳子剪成 m 段（m、n 都是整数，2≤n≤58,并且 m≥2）。
 *
 * 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]k[1] … k[m] 可能的最大乘积是多少？
 *
 * 例如当绳子的长度是 8 时，我们把它剪成长度分别为2、3、3的三段，此时得到最大的乘积18。
 *
 * 小学奥数问题：将 N 尽量分为多的 3。
 *
 * N = N1 + N2 + N3 +.....Ni + ....Ns;
 * 若 Ni = 5,一定还可以分下去，因为 3 * (Ni - 3) >= Ni, 划分一下 2Ni >= 9,成立，所以Ni必定小于5
 * 若 Ni = 4，必定可以拆分为 Ni = 2 * 2，
 * 若 Ni = 3，
 */
public class Solution {
    public int maxProductAfterCutting(int N)
    {
        // N 取 2、3的时候，至少要分为两个数，1 * 1、 1 * 2
        if (N <= 3) return 1 * (N - 1);

        int ret = 1;

        if (N % 3 == 1) {
            ret *= 4;
            N -= 4;
        } else if (N % 3 == 2) {
            ret *= 2;
            N -= 2;
        }
        while (N > 0) {
            ret *= 3;
            N -= 3;
        }
        return ret;

//        // 如果 N 是 3 的倍数
//        if (N % 3 == 0) return (int)Math.pow(3, N/3);
//
//        // 余数为 1， 则再取出一个 3 ，和 1 拆为 2 * 2
//        else if (N % 3 == 1) return (int)Math.pow(3D, N/3 - 1) * 4;
//
//        // 余数为 2
//        else if (N % 3 == 2) return (int)Math.pow(3D, N/3) * 2;
//        return -1;

//        if (n == 2) return 1;
//        if (n == 3) return 2;
//        switch(n % 3) {
//            case 0 :
//                return (int)Math.pow(3, n / 3);
//            case 1 :
//                return (int)Math.pow(3, n / 3 - 1) * 2 * 2;
//            case 2 :
//                return (int)Math.pow(3, n / 3) * 2;
//            default :
//                return 0;
//        }
    }
}
