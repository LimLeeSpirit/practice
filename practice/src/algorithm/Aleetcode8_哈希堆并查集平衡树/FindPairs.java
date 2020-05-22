package algorithm.Aleetcode8_哈希堆并查集平衡树;

import java.util.HashMap;
import java.util.Map;

/**
 *  给定数组，在其中找出满足 a+b=c+d 的数对，(a, b) 和 (c, d)
 *
 *  有点类似四数之和，只不过四数之和是加起来等于固定值，这是找出不同的数对，使数对之和相同
 */
public class FindPairs {

    public static boolean findPairs(int[] nums) {
        Map<Integer, Pairs> pairs = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1; j < nums.length; j ++) {
                int tmp = nums[i] + nums[j];
                if (pairs.containsKey(tmp)) {
                    // 打印出来
                    Pairs p = pairs.get(tmp);
                    System.out.println(nums[i] + "," + nums[j] + "=" + p.first + "," + p.second);
                    return true;
                } else {
                    pairs.put(tmp, new Pairs(nums[i], nums[j]));
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,7,10,20,9,8};
        findPairs(nums);
    }
}

class Pairs{
    int first;
    int second;

    public Pairs(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
