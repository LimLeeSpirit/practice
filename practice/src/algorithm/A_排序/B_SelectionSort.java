package algorithm.A_排序;

/**
 *  选择排序： 不稳定 O(n^2)
 *
 *
 *  每次选一个最小的排到前面,遍历 n 次，每次需要和后面的元素进行比较，
 *  所以最好最坏情况都是O(n^2)，在计算时间复杂度的时候，要考虑到 比较时间 和 交换时间。
 */
public class B_SelectionSort {

    public static void selectionInsert(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i ++) {
            int minIndex = i;
            // 在后面找最小的值和他的下标
            for (int j = i + 1; j < n; j ++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            // 找完后，如果当前位置不是最小值，则让最小值和当前位置进行替换
            // 所以最多交换 n 次
            if (minIndex != i) {
                int tmp = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = tmp;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {32,4,21,4,34456,67,78,87,8,45,899,1,3434,34};
        selectionInsert(nums);
        for (int a: nums) {
            System.out.print(a + " ");
        }
    }


}
