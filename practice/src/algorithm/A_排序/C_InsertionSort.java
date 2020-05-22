package algorithm.A_排序;

/**
 *  插入排序 ：从前往后维持一个升序效果，稳定的排序算法。
 *      如果是有序的，则只需要遍历 n - 1 次即可，所以时间复杂度最好O(n)，若是倒叙，则
 *      需要遍历n - 1次，每次都需要移动线性级别次数，最差时间复杂度O(n^2)
 *
 *
 *  当前处理到的是 i ，看他前面一个 j = i - 1是不是大于他，是则继续往前找到所以大于 他的
 *
 *  所以这里i 需要从 1 开始
 *
 *  第三次自己写终于搞明白了哈哈
 */
public class C_InsertionSort {
    public static void insertionSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i ++) {
            int j = i;
            int tmp = nums[i];
            // 如果前一个元素大于 当前元素，则继续查找前面的元素都有哪些大于tmp，这些元素统统后移一位。
            while (j >= 1 && nums[j - 1] > tmp) {
                nums[j] = nums[j - 1];
                j --;
            }
            // 移完之后就将这个 tmp 放到他应该在的地方。
            nums[j] = tmp;
        }
    }


    public static void main(String[] args) {
        int[] nums = {32,34,65,776,8,8,9};
        insertionSort(nums);
        for (int a: nums) {
            System.out.print(a + " ");
        }
    }
}
