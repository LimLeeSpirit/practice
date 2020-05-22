package algorithm.Aleetcode10_数组.数组或者字符串运算.leetcode16;

/**
 *  找出离给定目标最接近的三数之和
 *  和三数之和思路一致，额外需要解决的就是保存两个标志整数，用来标志小于target的最大数和大于target的最小数。
 *
 *  注意一些边界条件以及运算的溢出
 *
 *  可以写个博客
 */

import java.util.Arrays;

public class Solution {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;

        int leftP;

        int minT = nums[0] + nums[1] + nums[2] < target ? nums[0] + nums[1] + nums[2]: Integer.MIN_VALUE+1;
        int maxT = nums[length-1] + nums[length-2] + nums[length-3] > target ? nums[length-1] + nums[length-2] + nums[length-3] : Integer.MAX_VALUE;


        for(int i = 0; i < length-2; i ++){
            // 最外层的去重方法
            if(i>0 && nums[i]==nums[i-1]) {
                continue;
            }

            leftP = i+1;
            int rightP = length-1;

            while(leftP<rightP) {
                int temp = nums[i] + nums[leftP] + nums[rightP];
                if (temp < target) {
                    minT = minT > temp ? minT : temp;
                    leftP += 1;

                } else if (temp > target) {
                    maxT = maxT > temp ? temp : maxT;
                    rightP -= 1;
                } else if (temp == target){
                    return target;
                }
                System.out.println("i:"+i);
                System.out.println("leftP:"+leftP);
                System.out.println("rightP:"+rightP);
                System.out.println("temp:" +temp);
                System.out.println("minT:"+minT);
                System.out.println("maxT:"+maxT);

            }
        }
        System.out.println(minT);
        System.out.println("大的距离："+(long)(maxT-target));
        System.out.println("小的距离："+(long)(target-minT));

        return  ((long)maxT-target) > ((long)target-minT) ? minT : maxT;
    }
}
