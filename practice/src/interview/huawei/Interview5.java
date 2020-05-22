package interview.huawei;

import java.util.Scanner;

public class Interview5 {
    public static int K;
    public static int[] max;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] nums = new int[N];
        // 分段法，将nums数组分成sqrt(N)个小数组，每个数组得到一个最大值，查询的时候判断左右区间在哪些个小数组里，若是包含了，就
        // 直接取最大值，否则遍历；更新的时候先找到在哪个小数组区间，比较最大值更新。
        K = (int)Math.sqrt(N);
        max = new int[K];  // 9->3; 14->3
        init(nums, max, N, K);
        for (int i = 0; i < M; i ++) {
            String s = in.nextLine();
            if (s.charAt(0) == 'Q') {
                query(nums, s.charAt(2) - '0' - 1, s.charAt(4) - '0' - 1);
            } else {
                update(nums, s.charAt(2) - '0' - 1, s.charAt(4) - '0');
            }
        }
    }

    /**
     * 由于最后一段数组长度不定，所以处理起来有点繁琐
     * @param nums 原始数组
     * @param max  分段小数组的最大值组成的数组
     * @param N    原始数组大小
     * @param K    最大值组成的数组
     */
    private static void init(int[] nums, int[] max, int N, int K) {
        for (int i = 0; i < K - 1; i ++) {
            int cur_max = nums[i * K];
            for (int j = cur_max + 1; j < (i + 1) * K; j ++) {
                cur_max = Math.max(cur_max, nums[j]);
            }
            max[i] = cur_max;
        }
        int c_max = nums[(K - 1) * K];
        for (int k = (K - 1) * K + 1; k < N; k ++) {
            c_max =  Math.max(c_max, nums[k]);
        }
        max[K - 1] = c_max;
    }

    private static void query(int[] nums, int left, int right) {
        int ans = nums[left];
        for (int i = 0; i < K - 1; i ++) {
            if (left <= i && right >= (i + 1) * K) {
                ans = Math.max(max[i], ans);
            } else if (left <= i && right < (i + 1) * K){  // 左半边
                for (int z = i; z <= right; z ++) {
                    ans = Math.max(nums[z], ans);
                }
            } else if (left > i && right >= (i + 1) * K) { // 右半边
                for (int z = left; z <= (i + 1) * K; z ++) {
                    ans = Math.max(nums[z], ans);
                }
            }
        }
        System.out.println(ans);
    }

    private static void update(int[] nums, int idx, int value) {

    }
}
