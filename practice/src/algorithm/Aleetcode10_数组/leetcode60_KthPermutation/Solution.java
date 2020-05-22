package algorithm.Aleetcode10_数组.leetcode60_KthPermutation;

import java.util.LinkedList;
import java.util.List;

/**
 *
 *  写出 n 的全排列中，从小到大的第 k 个排列
 *
 *  可以用 leetcode31 下一个排列的思路来做，只不过要做 k - 1 次，时间复杂度O（k * (n + n)), 所以比较慢
 *
 *  可以写个博客！！
 *
 */
public class Solution {
    public String getPermutation(int n, int k) {
        int[] cache = new int[n];
        for (int i = 0; i < n; i ++) cache[i] = i + 1;

        while (k > 1) {
            int j = 0;
            for (int i = n - 2; i >= 0; i --) {
                if (cache[i] < cache[i + 1]) {
                    j = i;
                    break;
                }
            }

            // swap
            for (int z = n - 1; z >= 0; z --) {
                if (cache[z] > cache[j]) {
                    int tmp = cache[z];
                    cache[z] = cache[j];
                    cache[j] = tmp;
                    break;
                }
            }

            // j + 1 及其后面保持升序
            reverse(cache, j + 1, n - 1);
            k --;
        }
        StringBuilder sb = new StringBuilder();
        for (int a : cache) sb.append(a);
        return sb.toString();
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[r];
            nums[r] = nums[l];
            nums[l] = tmp;
            l ++;
            r --;
        }
    }

    public static String getPermutation3(int  n, int k) {
        /**
         * 这个方法才是最牛逼的。我自己最开始想的思想也是和他一样，但是我自己却很难把它写出来。
         * 原理就是：一位一位地找，比如n=4，k=9。第一位：k/((n-1)!)= 9/6 = 1...3,代表第一位应该在1，2，3，4的第二个：2
         *         然后再求第二个元素：余数为3，要在1，3，4之间找第二个。
         */
        int[] factorial = new int[]{1,1,2,6,24,120,720,5040,40320,362880};
        //初始化 1,2,3,4,...n
        List<Integer> numbers = new LinkedList<>();
        for(int i = 0; i<n; i++){
            numbers.add(i+1);
        }

        // 为什么这么简单啊！！他的想法和我明明一样，但是代码这么简洁就出来了？？？？
        StringBuilder result = new StringBuilder();
        k--;
        for(int i = 0; i<n; i++){
            int currentNumber = numbers.remove(k / factorial[n-i-1]);
            result.append(currentNumber);
            k  %=  factorial[n-i-1];
        }

        return result.toString();
    }

}
