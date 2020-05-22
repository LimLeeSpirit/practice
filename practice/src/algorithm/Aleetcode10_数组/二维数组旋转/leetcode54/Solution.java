package algorithm.Aleetcode10_数组.二维数组旋转.leetcode54;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵，顺时针螺旋取矩阵的元素
 * 脑子好笨哦，想不出，即使想出了也写不来。学习一下，写的很巧妙
 * 仔细分析一下：就是重复选取 右-下-左-上 这个顺序的元素，直接用while循环寻找就很好想了。
 *
 * 每个元素只遍历一遍：时间复杂度O(n),空间复杂度O(n)
 *
 * 第三次自己拿着没想清楚，所以第一时间没写出来，上行-右列-下行-左列的顺序进行遍历，变量没有想好怎么写，
 * debug的时候在写下行和左列的时候，边界成固定思维了
 *
 */
class Solution {
    public List< Integer > spiralOrder(int[][] nums) {
        List<Integer> ret = new ArrayList<>();
        if (nums == null || nums.length == 0) return ret;

        int m = nums.length - 1, n = nums[0].length - 1;
        int x1 = 0, x2 = m;
        int y1 = 0, y2 = n;

        while (x1 <= x2 && y1 <= y2) {
            for (int i = y1; i <= y2; i ++) ret.add(nums[x1][i]);

            for (int i = x1 + 1; i <= x2; i ++) ret.add(nums[i][y2]);

            if (x1 < x2 && y1 < y2) {
                for (int i = y2 - 1; i >= y1; i --) ret.add(nums[x2][i]);

                for (int i = x2 - 1; i > x1; i --) ret.add(nums[i][y1]);
            }
            x1 ++;
            x2 --;
            y1 ++;
            y2 --;
        }

        return ret;
    }

    public static void main(String[] args) {
        for (int i = 3; i > 3; i --) {
            System.out.println("2e313");
        }
    }
}

