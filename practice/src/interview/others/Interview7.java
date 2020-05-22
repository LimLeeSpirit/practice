package interview.others;

import java.util.Random;

/**
 *  有5亿用户，用户id是int类型，在1到5亿区间连续，从这5亿用户中均匀、随机抽取10万个用户id发促销邮件。
 */
public class Interview7 {
    public static void main(String[] args) {
        // 5 0000 0000 / 10 0000 = 5000 个区间
        getRandomCustemers(100, 10);
    }
    public static int[] getRandomCustemers(int totol, int nums) {
        int slices = totol / nums;
        Random random = new Random();
        int[] ans = new int[nums];
        for (int i = 0; i < nums; i ++) {
            ans[i] = i * slices + random.nextInt(slices);
        }
        for (int a : ans) {
            System.out.println(a + " ");
        }
        return ans;
    }
}
