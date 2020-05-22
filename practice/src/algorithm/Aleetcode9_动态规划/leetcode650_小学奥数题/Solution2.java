package algorithm.Aleetcode9_动态规划.leetcode650_小学奥数题;

public class Solution2 {
    /**
     *  1、n>1 都要先进行copyAll
     *  2、第一次paste ‘A’
     *  3、则n为质数时，步数为n
     *  4、n为偶数时候，令a[n]代表n个‘A’需要次数，a[n] = a[n/2]+1，a[n/2]继续处理，重复子问题
     *
     *  这个思路比 寻找质数之和要好多了，这个思路比较容易想到，代码也不是很难写。
     * @param n
     * @return
     */
    public int minSteps(int n) {
        if (n == 1) return 0;
        int sub = 0;
        for (int i = n - 1; i >= 2; i--) {
            if (n % i == 0) {
                sub = i;
                break;
            }
        }
        // 先判断 n  是不是质数，如果是，则直接返回n，
        // 不是，则继续求子问题。这个思路应该很好懂呀，还是把自己绕进去了。
        if (sub == 0) {
            return n;
        } else {
            return minSteps(sub) + n / sub;
        }
    }
}
