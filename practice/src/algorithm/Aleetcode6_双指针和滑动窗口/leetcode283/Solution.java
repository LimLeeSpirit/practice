package algorithm.Aleetcode6_双指针和滑动窗口.leetcode283;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * hhhh机智的我想出来了，类似双指针，将不为0的往前移动，移完之后，后面的全部归0
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0;
        for (int j = 0; j < n; j ++) {
            if (nums[j] != 0) nums[i ++] = nums[j];
        }
        while (i < n) {
            nums[i] = 0;
            i ++;
        }
    }

    public static void main(String[] args) {
        String s = "dog cat cat dog";
        String[] r = s.split(" ");
        for (String ss : r) {
            System.out.println(ss);
        }
        System.out.println(r.length);
    }
}
