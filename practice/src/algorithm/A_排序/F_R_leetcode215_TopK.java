package algorithm.A_排序;

import java.util.Random;

/**
 * leetcode 215
 * 在未排序的数组中找到第 k 个最大的元素。
 *
 * 利用快排的思路，找到升序后第下标为 n - k 处的元素值，并且不需要将数组完全排序。
 */
public class F_R_leetcode215_TopK {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSort(nums, n - k, 0, n - 1);
    }

    private int quickSort(int[] nums, int m, int left, int right) {
        if (left >= right) return nums[left];

        // 随机选择 pivot 的效果会比选最后一个元素当作 pivot 效果好数十倍！
        Random random = new Random();
        int pivotIndex = left + random.nextInt(right - left);
        int pivot = nums[pivotIndex];

        // 将选出来的这个 pivot 放到最后一个元素的位置
        swap(nums, pivotIndex, right);

        int storeIndex = left;
        for (int i = left; i <= right; i ++) {
            if (nums[i] < pivot) {
                swap(nums, i, storeIndex);
                storeIndex ++;
            }
        }
        swap(nums, storeIndex, right);

        // 如果交换到的下标就是目的下标，那么就成功找到了
        if (storeIndex == m) return nums[storeIndex];
        // 如果交换到的下标太小了，则说明需要在右子数组去中
        else if (storeIndex < m) return quickSort(nums, m, storeIndex + 1, right);
        else return quickSort(nums, m, left, storeIndex - 1);
    }

    private void swap(int[] nums, int l, int r) {
        int tmp = nums[r];
        nums[r] = nums[l];
        nums[l] = tmp;
    }
}
