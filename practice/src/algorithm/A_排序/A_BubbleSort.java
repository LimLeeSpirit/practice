package algorithm.A_排序;

/**
 * 稳定的排序有：冒泡排序、插入排序、归并排序
 *
 * 冒泡排序 O（n^2）  稳定
 * 卧槽，第一遍写的时候差点写错了，这个一定要想好了排序的过程才行，想当然是不行的
 *
 *      每一次遍历都将该层的最大值放到后头去。
 *      需要 n 次遍历，每次遍历比较相邻元素，需要线性级别的比较和交换，所以是最好最坏情况的时间复杂度都是O（n^2）
 *      优化之后最优情况可以达到O（n）
 */
public class A_BubbleSort {
    public static void bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i --) {
            // 优化
            boolean find = false;
            for (int j = 0; j < i; j ++) {
                if (nums[j] > nums[j + 1]) {
                    // 最多交换 n - 1 + n - 2 + n - 3 +.... + 1 = n(n - 1)/2 所以是n的平凡级别次
                    int tmp = nums[j];
                    nums[j]  = nums[j + 1];
                    nums[j + 1] = tmp;
                    find = true;
                }
            }
            // 如果已经有序了，则不需要再遍历了
            if (!find) break;
        }
    }

    public static void main(String[] args) {
        int[] nums = {32,4,21,4,34456,67,78,87,8,45,899,1};
        bubbleSort(nums);
        for (int a: nums) {
            System.out.print(a + " ");
        }
    }
}
