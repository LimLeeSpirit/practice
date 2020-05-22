package algorithm.Aleetcode10_数组;

/**
 * 给定 3 个升序数组，从每个数组中取一个元素，使得距离 distance = max( |a[] - b[]|, |b[]-c[]|, |a[]-c[]|) 最小
 *
 * 暴力解法：三个 for 循环，对每个三元素构成的差值绝对值进行比较，保留最小的。
 * 显然没有用到数组是升序这个条件。
 *
 * 最小距离法：考虑当前情况为：
 *
 * ai, bj, ck， 若  ai <= bj <= ck,则当前最小值为 Dist_i = ck - ai
 * 则下一个最小值可能出现在：ai+1, bj,   ck
 *                      ai,   bj+1, ck
 *                      ai,  bj,    ck+1，
 *
 *                      只可能出现在第一种情况，ai+1, bj, ck里面，所以需要找到当前最小值是哪个，其下标 ++，进行下一次判断
 *
 * 时间复杂度为O（l + m + n）
 */
public class MinDist {
    public static int getMin(int a, int b, int c) {
        return Math.min(Math.min(Math.abs(a-b), Math.abs(a-c)), Math.abs(b-c));
    }

    public static int getMax(int a, int b, int c) {
        return Math.max(Math.max(Math.abs(a-b), Math.abs(a-c)), Math.abs(b-c));
    }

    public static int getDist(int[] a, int[] b, int[] c) {
        int m = a.length, n = b.length, q = c.length;
        int max_gap = Integer.MAX_VALUE;

        int i = 0, j = 0, k = 0;

        while (i < m && j < n && k < q) {
            int cur_max = getMax(Math.abs(a[i] - b[j]), Math.abs(a[i] - c[k]), Math.abs(b[j] - c[k]));
            max_gap = Math.min(cur_max, max_gap);

            int min_num = getMin(a[i], b[j], c[k]);

            if (min_num == a[i]) i ++;
            else if (min_num == b[j]) j ++;
            else k ++;
        }
        return max_gap;
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 5, 7};
        int[] b = {10, 12, 14, 16, 17};
        int[] c = {20, 21 ,23, 24, 37, 30};
        System.out.println(getDist(a, b, c));
    }
}
