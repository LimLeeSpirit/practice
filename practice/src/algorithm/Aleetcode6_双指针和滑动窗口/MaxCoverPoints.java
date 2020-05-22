package algorithm.Aleetcode6_双指针和滑动窗口;

/**
 * 给定坐标轴上的一堆点，升序排列，在给定一根长度为 L 的棍子，求棍子最多可以覆盖多少个点？
 *
 * 比如 {1, 3, 7, 8, 10, 11, 12, 13, 15, 16, 17, 19, 25}
 *      棍子长度 L = 8
 *      覆盖的坐标点为： 7, 8, 10, 11, 12, 13, 15
 *      最长覆盖点为7个
 * 这个题一看，有点简单，又有点复杂，其实转化为数学问题：
 * 找出所有满足： nums[j]- num[i] <= L && nums[j+1] - nums[i] > L 中的 j-i+1的最大值即可
 *
 * 目的就是找出i，j，而且发现j是随着 i 单增不减的，这就好办了，用双指针！i和j都是只从前往后走一次，所以时间复杂度O（n）
 */
public class MaxCoverPoints {
    public static int maxCoverPoints2(int[] nums, int L) {
        int n = nums.length;
        int ans = 1;
        for (int i = 0, j = 1; i < n; i ++) {
            while (j < n && nums[j] - nums[i] <= L) j ++;
            ans = Math.max(ans, j - i);
            System.out.printf("i:%d,j:%d",i, j);
            System.out.println();
        }
        System.out.println(ans);
        return ans;
    }

    public static int maxCoverPoints(int[] nums, int L) {
        int i=0, j=1;
        int count = 2; // 默认木棍长度大于 1
        int maxCover = 1;
        int start = 0; // 记录开始下标
        int len = nums.length;
        while (i<len && j < len) {
            while (j<len && nums[j]-nums[i] <= L) {
                count ++;
                j++;
            }
            j--;
            count--;
            if (count > maxCover) {
                maxCover = count;
                start = i;
            }
            i++;
            j++;
        }
        System.out.println("覆盖的点为：");
        for (int k=start; k < start + maxCover; k++) {
            System.out.printf(nums[k] + " ");
        }
        System.out.println();
        return maxCover;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 7, 8, 17, 21};
        System.out.println(maxCoverPoints2(nums, 7));
    }
}
