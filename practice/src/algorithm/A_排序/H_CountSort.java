package algorithm.A_排序;

/**
 * 计数排序
 *
 * 比如给定 10^7 次方个数，每个数在 0-999999 之间，这样就用计数排序就很方便。
 *
 * 思路：输入 n 个数，将输入的数据转化为 下标 存储在额外开辟的数据中，要求输入的数的个数一定要大于给定的数的范围
 *
 *      统计好数组中每个数出现的次数，然后从前往后将数字放到数组中，每个相同的元素出现了多少次，就放多少次
 */
public class H_CountSort {
    // 给定数，在 0～100 之间，有很多重复出现的数，用最快的方式对他们排序
    public static void countSort(int[] nums) {
        int[] cnt = new int[101];
        for (int a : nums) cnt[a] ++;
        for (int i = 1, k = 0; i <= 100; i ++) {
            while (cnt[i] > 0) {
                nums[k ++]  = i;
                cnt[i] --;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {89,23,45,6,67,78,90,12};
        countSort(nums);
        for (int a : nums) System.out.print(a + " ");
    }
}
