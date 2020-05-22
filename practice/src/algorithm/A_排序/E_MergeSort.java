package algorithm.A_排序;

/**
 * 归并排序，可以有两种思考方式，自顶向下或者自底向上，最好和最差时间复杂度都是O（nlgn）
 *
 * 自顶向下利用递归，将原数组进行划分成 logn 个子数组，由于是递归，所以在进行排序的时候会申请lgn的虚拟机栈空间
 * 自底向上是利用的迭代的方式，所以时间空间是常数级别。
 *
 * 如果采用自顶向下的方式，算法还需要开辟一个中间数组用来存放临时变量，所以空间复杂度O（n + lgn)；
 *
 * 可以结合leetcode148：利用归并排序对链表进行排序；和E_Count_Inversions_In_Array
 *
 * 我自己实现的归并排序，在看完这个讲解（https://www.bilibili.com/video/av15962030?p=2）后
 * 就懂了，真的好。她先讲了 合并两个有序子数组，然后再将数组划分，划分之后进行合并。
 */
public class E_MergeSort {
    public static void mergeSort(int[] nums) {
        mSort(nums, new int[nums.length], 0, nums.length-1);
    }

    /**
     * 先分：一直划分划分到只剩一个元素为一个子序列
     * @param nums      原始数组
     * @param tmp       临时数组
     * @param leftStart 左边子序列起始下标
     * @param rightEnd  右边子序列结束下标
     */
    private static void mSort(int[] nums, int[] tmp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }
        // 一分为二
        int mid = leftStart + rightEnd >> 1;
        // 再继续分左边子数组
        mSort(nums, tmp, leftStart, mid);
        // 分右边子数组
        mSort(nums, tmp, mid + 1, rightEnd);
        // 分完了把 两个有序子数组 进行 合并。
        merge(leftStart, mid+1, rightEnd, tmp, nums);
    }

    /**
     * 再治：对两个有序子序列进行合并。
     * @param ls  左边子序列的开始下标
     * @param rs 右边子序列的开始下标
     * @param re   右边子序列的结束下标
     * @param tmp        临时数组，前后两个子数组的结果排序结果会保存在 tmp 中，之后又会从 tmp 中将排好序的元素捣回到原始数组中
     *                   而且将 tmp 作为参数 传递到 merge 方法中，可以减少空间复杂度，避免在 merge 中反复创建 tmp
     * @param nums       原始数组
     */
    private static void merge(int ls, int rs, int re, int[] tmp, int[] nums) {
        int le = rs - 1;
        // tmpStart 代表此次元素放在 tmp 的哪个下标位置，
        int tmp_idx = ls;
        int length = re - ls + 1;
        while (ls <= le && rs <= re) {
            // 降序
            //tmp[tmpStart ++] = nums[leftStart] > nums[rightStart] ? nums[leftStart++] : nums[rightStart++];

            // 升序
            // tmp[tmpStart ++] = nums[leftStart] < nums[rightStart] ? nums[leftStart++] : nums[rightStart++];
            if (nums[ls] < nums[rs]) {
                tmp[tmp_idx ++] = nums[ls ++];
            } else {
                tmp[tmp_idx ++ ] = nums[rs ++];
            }
        }

        // 左右子数组最多只剩下一个
        while (ls <= le) {
             tmp[tmp_idx ++] = nums[ls ++];
        }

        while (rs <= re) {
            tmp[tmp_idx ++] = nums[rs ++];
        }

        // 将 tmp 里有序的元素捣回到原数组。
        for (int i = 0; i < length; i ++, re --) {
            nums[re] = tmp[re];
        }
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] { 9, 8, 7, 6, 5, 4, 3,34,6556,67,67, 2, 10,90};
        mergeSort(nums);
        for (int x : nums) {
            System.out.print(x+ " ");
        }
    }
}
