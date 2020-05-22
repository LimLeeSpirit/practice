package algorithm.A_排序;

/**
 *  快排，每次选一个旗帜，将小于旗帜的放在旗帜左边，大于旗帜的放在旗帜右边，
 *  所以这一性质也就保证了：每一次排序后，旗帜代表的元素都会到达排序后她最后应该在的位置
 *
 *  然后递归对旗帜左边和右边进行快排
 *
 *  所以时间复杂度平均是 O（nlgn），最坏是逆序的时候 O（n^2）；
 *  最好是旗帜可以每次都划分得很均匀，此时最好是O（nlgn），因为用的递归，需要用递归的计算方法
 *
 *  关键就是 partition 函数的逻辑，每一次排序后，旗帜代表的元素都会到达他的最后应该在的位置
 *
 *  快排的扩展题力扣 215 题：求第 k 大元素，实现过一遍后，对快排的理解更深了！
 *
 *  快排不是稳定的排序，比如序列 3·, 6, 5, 4, 1, 3·· 选 最后一个 3·· 为 pivot，第一个分区后的结果为
 *                          1, 3··, 5, 4, 3·, 6
 *
 */
public class F_QuickSort {
    private static void swap(int left, int right, int[] nums) {
        if (left >= right) { return; }
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
    private static void partition(int left, int right, int[] nums) {
        /**
         *  快排有一个最关键的点就是：每一次排序后，旗帜代表的元素都会到达他的最后应该在的位置！
         */
        if (left >= right) { return; }
        // 旗帜
        int pivot = nums[right];

        // 需要记录的下标
        int storeIndex = left;
        for (int i = storeIndex; i <= right; i ++) {
            // 如果当前值小于旗帜，则与需要记录的下标进行交换，然后下标 storeIndex ++，相当于 storeIndex
            // 继续往后走，走到最后的那个位置
            if (nums[i] < pivot) {
                swap(storeIndex, i, nums);
                storeIndex ++;
            }
        }
        // 最后将旗帜和 storeIndex 的值进行交换。此时旗帜就到了他最后应该到的位置，即整个数组排序好后旗帜应该在的位置。
        // 所以一般将旗帜取为整个数组中的中间的元素是最好的情况。
        swap(storeIndex, right, nums);
        // 然后再分别对旗帜左右两边的数组进行递归排序。
        partition(left, storeIndex - 1, nums);
        partition(storeIndex + 1, right, nums);
    }

    private static void quickSort(int[] nums) {
        partition(0, nums.length-1, nums);
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 5, 4, 1, 4};
        quickSort(nums);
        for (int a : nums){
            System.out.print(a + " ");
        }
    }
}
