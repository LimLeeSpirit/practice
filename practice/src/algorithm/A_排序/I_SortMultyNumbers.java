package algorithm.A_排序;

import java.util.Map;
import java.util.TreeMap;

/**
 * 如何对有大量重复的元素的数组进行排序
 *
 * 如果直接快排，则是 nlogn 的复杂度。利用含有大量重复元素这个条件。可以优化：
 * 先计算出每个元素的个数，按照从小到大的顺序进行遍历，把元素重新放在数组里，时间复杂度O（n1 + n2）= O（n）
 *
 * 这里注意一点：TreeSet 和 TreeMap，TreeSet 是一个有序集合，遍历元素的时候元素是按照加入的顺序进行输出的；
 *             TreeMap 是一种有序映射，按照 key 升序排列的，还可以进行在声明 TreeMap 的时候为其指定比较器。比如按照 key
 *             降序排列。还可以按照 value 降序/升序排序。
 *
 *
 *
 *    如果是知道数的范围大小可以用数组，计数排序；不知道就用TreeSet，其实也是计数排序
 */
public class I_SortMultyNumbers {
    public static void sortMultyNumbers(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i ++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int index = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            System.out.println("key" + key);
            while ((val --) > 0) {
                nums[index ++] = key;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,1,-1,2,-1,2,3};
        sortMultyNumbers(nums);
        for(int a : nums) {
            System.out.print(a + " ");
        }
    }
}

