package algorithm.A_排序;

/**
 *  给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，
 *  使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 *  此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 *  法1：其实就是想排序。只不过元素只有3个,计数排序
 *
 *  法2：此题也可以用一次遍历，就是传统的荷兰旗问题，可以快速排序思想
 *
 */

public class H_leetcode75 {
    public static void sortColors(int[] nums) {
        int[] cnt = new int[3];
        for (int a : nums) {
            cnt[a]++;
        }
        int i = 0;
        for (int j = 0; j < 3; j ++) {
            while (cnt[j] > 0) {
                nums[i ++] = j;
                cnt[j] --;
            }
        }
    }

    // 快排思路，难以想到，仅仅使用了常数空间
    public void sortColors2(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int i = l - 1, j = r + 1;
        while (l < j) {
            if (nums[l] < 1) swap(nums, ++ i, l ++);
            else if (nums[l] > 1) swap(nums, l, -- j);
            else l ++;
        }
    }

    private void swap(int[] nums, int i , int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
