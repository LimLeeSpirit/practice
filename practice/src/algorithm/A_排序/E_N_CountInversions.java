package algorithm.A_排序;

/**
 * 利用归并排序思想求数组中的逆序对,在左边子数组中，如果某个元素 > 右边子数组的元素，那么就构成了逆序对
 *
 * 对于归并排序，我们需要的只是排序，将原数组排成一个有序数组就行了。
 * 但是对于本题：计算逆序对，是在排序的过程中，同时获得逆序对。
 * 逆序对数量 = 左子数组中的逆序对 + 右子数组中的逆序对 + 左右两数组中的逆序对
 *
 * 因为子序列排成的是升序，所以从子序列的后面往前面计算。
 */
public class E_N_CountInversions {
    //数组中的逆序对
    public static int inversePairs(int[] nums){
        if( nums == null || nums.length <= 1) {
            return 0;
        }
        int[] tmp = new int[nums.length];

        return mergeCount(nums, tmp, 0, nums.length-1);
    }

    public static int mergeCount(int[] nums, int[] tmp, int leftStart, int rightEnd){
        if(leftStart >= rightEnd){
            // tmp[leftStart] = nums[leftStart];
            return 0;
        }
        int mid = leftStart + rightEnd >> 1;

        int leftCount = mergeCount(nums, tmp, leftStart, mid);
        int rightCount = mergeCount(nums, tmp, mid + 1, rightEnd);

        int leftEnd = mid;// i 初始化为前半段最后一个数字的下标

        int tmpEnd = rightEnd;//辅助数组复制的数组的最后一个数字的下标

        int rs = mid + 1;
        int count = 0; //计数--逆序对的数目

        while(leftStart <= leftEnd && rs <= rightEnd){
            if (nums[leftEnd] > nums[rightEnd]){
                tmp[tmpEnd --] = nums[leftEnd --];
                // 这个计算咋就是这么多呢？哦对！因为 是两个有序的子序列。
                count += rightEnd - mid;
                System.out.println("count:" + count);
            } else {
                tmp[tmpEnd --] = nums[rightEnd --];
            }
        }

        while (rightEnd >= rs) {
            tmp[tmpEnd --] = nums[rightEnd --];
        }

        while (leftEnd >= leftStart) {
            tmp[tmpEnd --] = nums[leftEnd --];
        }

        return leftCount + rightCount + count;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,0};
        System.out.println(inversePairs(nums));
    }
}
