package algorithm.Aleetcode2_链表;

/**
 *  合并有序数组  和 leetcode88、21相似
 *
 *  给出一个数组，1 5 6 7 9， 2 4 8 10 13 14。
 *      mid 在右边子数组的第一个元素的下标
 *      前后部分都是升序，怎样将整个数组变得有序
 *
 *      也可以用归并排序的 归步骤的思想：合并两个有序子序列
 */
public class MergeTwoOrderedArrays {
    // 我现在写这种逻辑题，得心应手哦
    public static void merge2(int[] nums, int mid) {
        int i = 0;
        int n = nums.length;
        while (i < mid) {
            if (nums[i] > nums[mid]) {
                swap(nums, i, mid);
                int j = mid + 1;
                // 这里也用tmp，因为在将小于mid的值左移动的时候，会将mid覆盖，所以需要都用tmp
                int tmp = nums[mid];
                while (j < n && nums[j] < tmp) {
                    nums[j - 1] = nums[j];
                    j ++;
                }
                nums[j - 1] = tmp;
            }
            i ++;
        }
    }

    private static void swap(int[] nums, int left, int right) {
        int tmp = nums[right];
        nums[right] = nums[left];
        nums[left] = tmp;
    }



    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 9, 2, 4, 8, 8, 10, 12, 14};
        merge2(nums, 4);
        for (int a : nums) {
            System.out.print(a + " ");
        }
    }
}
