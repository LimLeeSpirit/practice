package algorithm.Aleetcode1_二分.leetcode69;

/**
 *  求一个非负数的平方根，结果只取整数部分,相当于取真实值的下取整。
 */
public class Solution {
    /**
     * 标准解法，求点为满足单调性的最大点t，即t*t<=x, (t+1)*(t+1)则不满足了。
     * 一分钟就写出
     */
    public static int mySqrt(int x) {
        // if ( x == 0 || x == 1) { return x; }
        int l = 0, r = x;
        while (l < r) {
            int mid = l + r + 1>> 1;
            if (mid > x / mid) r = mid - 1;
            else l = mid;
        }
        return l;
    }


    /**
     * 使用的模版1，取最小的不满足规律的点，即t*t>x,(t-1)*(t-1)<=x，返回low或者low-1
     */
    public static int mySqrt2(int x) {
        if(x==0 || x==1) return x;
        int low = 0;
        int high = x/2 + 1;
        while(low < high){
            int mid = (low+high)>>1;
            if(mid > x/mid)
                high = mid;
            else
                low = mid+1;
        }
        return low<x/low? low:low-1;
    }


}
