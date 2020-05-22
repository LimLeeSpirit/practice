package algorithm.Aleetcode1_二分.leetcode35;

public class Test {
    public static void main(String[] args) {
        int[] nums = {1,3,4,6,9};
        // System.out.println(Aleetcode7_栈队列.leetcode42.binarySearch0(nums, 0,nums.length, 10));

        //disti();
        System.out.println("-1 = " + Integer.toBinaryString(-1));

        System.out.println("-1>>>32 =  " + Integer.toBinaryString(-1>>>32));
        System.out.println("-1>>>0 = " + Integer.toBinaryString(-1>>>0));

        System.out.println("-1>>>1 = " + Integer.toBinaryString(-1>>>1));
        System.out.println("-1>>>33 = " + Integer.toBinaryString(-1>>>33));

        System.out.println("-1>>>-1 = " + Integer.toBinaryString(-1>>>-1));
        System.out.println("-1>>>31 = " + Integer.toBinaryString(-1>>>31));

        System.out.println("1<<1 = " + Integer.toBinaryString(1<<-1));
        System.out.println("1<<33 = " + Integer.toBinaryString(1<<31));
        disti();

    }
    public static void disti() {
        /* 区分  >> 与 >>>
         * >>> unsinged right shift operator
         * >> singed right shift operator

         * 右移运算符 >>> 和 >> 的区别
         * >> singed right shift operator。 即有符号数的右移运算符，在对数的二进制位进行右移的时候会考虑数的符号位，符号位不参加移动
         * >>> unsinged right shift operator, 即非负数的右移运算符，在对数的二进制位进行右移的时候不考虑数的符号位，符号位也参加移动。具体实例如下：
         *
         * 位移的周期性。在进行移动的时候，会以32为周期。比如移动 1 位与移动 33 位 的效果一样。移动 -1 位会与移动 31 位的效果一样
         *
         * https://www.tutorialspoint.com/Bitwise-right-shift-operator-in-Java，
         * https://java-samples.com/showtutorial.php?tutorialid=269
         */

        int a = 60;
        int b = -60;
        int c;

        System.out.println("60  = " + Integer.toBinaryString(a));
        System.out.println("-60 = " + Integer.toBinaryString(b));

        //signed shift
        c = a >> 1;
        System.out.println("60 >> 1  = " + Integer.toBinaryString(c));

        c = a >> 2;
        System.out.println("60 >> 2  = " + Integer.toBinaryString(c));

        //unsigned shift
        c = a >>> 1;
        System.out.println("60 >>> 1 = " + Integer.toBinaryString(c) );

        c = a >>> 2;
        System.out.println("60 >>> 2 = " + Integer.toBinaryString(c) );

        c = b >> 1;
        System.out.println("-60 >> 1  = " + Integer.toBinaryString(c) );
        // 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 1 0  32位
        c = b >> 2;
        System.out.println("-60 >> 2  = " + Integer.toBinaryString(c) );

        c = b >> 3;
        System.out.println("-60 >> 3  = " + Integer.toBinaryString(c) );

        c = b >>> 1;
        System.out.println("-60 >>> 1 = " + Integer.toBinaryString(c));
        // 1111111111111111111111111100010 31位

        c = b >>> 2;
        System.out.println("-60 >>> 2 = " + Integer.toBinaryString(c));
        // 1111111111111111111111111100010 30位

        c = b >>> 3;
        System.out.println("-60 >>> 3 = " + Integer.toBinaryString(c));
        // 1111111111111111111111111100010 29位
    }
}
