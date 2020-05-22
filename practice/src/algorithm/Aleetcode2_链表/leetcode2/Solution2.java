package algorithm.Aleetcode2_链表.leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 *  如果两个数字是按照顺序结构存储在链表里呢？ 如何计算这里两个数字之和？ 445 题就是这样
 *  思考：由于是顺序结构，所以不能直接遍历链表进行求和，那样是从高位到地位的相加过程，不符合加法原理
 *
 *  最简单的就是将链表元素存放在数组中，从数组中逆序进行相加，结果存放在可变数组中（也可放在栈里面，更形象）。最后再形成一个链表。
 *  这样的时间复杂度是 O(n) + O(n) + O(n)  + O(n),也就是用的次数多点了。这里就用两个数组来表示两个顺序的数
 */
public class Solution2 {
    public static int[] addTwoArrays(int[] num1, int[] num2) {
        int len1 = num1.length-1, len2=num2.length-1, flag=0;
        List<Integer> reversedRes = new ArrayList<>();
        if (num1.length == 0 || num1==null) { return num2; }
        if (num2.length == 0 || num2==null) { return num1; }

        while (len1>=0 || len2>=0 || flag>0 ) {
            int x = len1>=0 ? num1[len1] : 0;
            int y = len2>=0 ? num2[len2] : 0;
            int sum = x + y + flag;
            reversedRes.add(sum % 10);
            flag = sum / 10;
            len1--;
            len2--;
        }
        int lenRes = reversedRes.size();
        int[] res = new int[lenRes];
        for (int i=0; i<lenRes; i++) {
            res[i] = reversedRes.get(lenRes-i-1);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] num1 = {2,9,4};
        int[] num2 = {1, 3,5};
        int[] res = addTwoArrays(num1, num2);
        for (int a : res) {
            System.out.print(a + " ");
        }
    }
}
