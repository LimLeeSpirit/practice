package algorithm.Aleetcode5_DFS和回溯.leetcode78;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 使用了一种更为容易思考的方式。比如数组[a, b, c]
 * 第一次加入： [a]
 * 第二次加入b：[a], 新增 [a, b], [b]
 * 第三次加入c：[a], [a, b], [b], 新增 [a, c], [a, b, c], [b, c], [c]
 *
 * 当前集合 = 上次集合 + 上次集合中各个子集加上当前元素 + 当前元素组成的单数集合
 * 对于 n 个元素的集合，共有 2^n个子集，包括空集
 */
public class Solution3 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ret;
        }

        ret.add(new ArrayList<>(Collections.singletonList(nums[0])));

        for (int i = 1; i < nums.length; i ++) {
            int size = ret.size();
            for (int j=0; j<size; j++) {
                List<Integer> tmp = new ArrayList<>(ret.get(j));
                tmp.add(nums[i]);
                ret.add(tmp);
            }
            ret.add(new ArrayList<>(Collections.singletonList(nums[i])));
        }

        // 最后加上空集，空集是任何集合的子集
        ret.add(new ArrayList<Integer>());
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2};
        List<List<Integer>> ret = subsets(nums);
        System.out.println("结果长度" + ret.size());
        for (List<Integer> a: ret) {
            for (int b : a) {
                System.out.print(b + "");
            }
            System.out.println();
        }
    }
}
