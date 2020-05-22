package algorithm.Aleetcode10_数组.数组或者字符串运算.leetcode18_数组;

/**
 *  四数之和
 *
 *  三数之和 leetcode 15
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        int length = nums.length;

        if(length==4 && nums[0]+nums[1] + nums[2] + nums[3]==target) {
            res.add(Arrays.asList(nums[0], nums[1], nums[2], nums[3]));
            return res;
        }

        for(int i=0; i < length - 3; i++){
            // 这个提速方法有点巧妙，当前的最小情况：若前四个加起来都大于了，就跳出遍历；
            //                    当前的最大情况：若此处的+后三个都小于了，那么就继续下一个判断。
            if (nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) {
                break;
            }
            if (nums[i] +  nums[length-1] + nums[length-2] + nums[length-3] < target) {
                continue;
            }

            // 最外层的去重方法
            if(i>0 && nums[i]==nums[i-1]) {
                continue;
            }

            for(int j = i + 1; j<length-2; j++) {
                if (nums[j] == nums[j-1] && j>i+1) { continue; }

                int leftP = j+1;
                int rightP = length-1;

                while(leftP < rightP) {
                    int temp = nums[i] + nums[j] + nums[leftP] + nums[rightP];
                    if (temp < target) {
                        leftP += 1;
                    } else if (temp > target) {
                        rightP -= 1;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[leftP], nums[rightP]));

                        // 内层的左指针去重方法，注意是一直到不重复，所以用while
                        while (leftP < rightP && nums[leftP]==nums[leftP+1]) {
                            leftP += 1;
                        }

                        // 内层的右指针去重
                        while (leftP < rightP && nums[rightP]==nums[rightP-1]) {
                            rightP -= 1;
                        }

                        leftP += 1;
                        rightP -= 1;
                    }
                }
            }

        }
        return  res;
    }
}
