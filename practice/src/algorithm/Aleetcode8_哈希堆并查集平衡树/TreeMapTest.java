package algorithm.Aleetcode8_哈希堆并查集平衡树;

import java.util.*;

/**
 * 对 TreeSet 本来就是按照 key 升序排列的有序映射，如果要做到按照 key 降序排列呢？ 需要在其构造器中输入一个比较器。
 *
 * 不能按照 value 进行排序，
 * 如果非要按照 value 进行排序的话，将，利用 Collections 的 sort 方法对 TreeSet 的 Entry 数组进行排序，再
 * 把排好序的 entry 放在 hashMap 中。
 */
public class TreeMapTest {
    public static void main(String[] args) {
        int[] nums = {4,1,-1,2,-1,2,3};
//         orderByKey(nums);
         orderByValue(nums);
        sortStrings();
    }

    public static void orderByKey(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>(
                new Comparator<Integer>() {
                    public int compare(Integer obj1, Integer obj2) {
                        // 按照 key 降序排序
                        // return obj2.compareTo(obj1);
                        return obj2 - obj1;
                        // 按照 key 升序排序，TreeMap 默认的排列方式
                        // return obj1.compareTo(obj2);
                    }
                }
        );

        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    /**
     * 根据 Value 对 TreeSet 进行排序的话，先要把排序结果放在 list 中；再将 键值对 放入 map
     * @param nums
     */
    public static void orderByValue(int[] nums) {
        Map<Integer, Integer> beforeSort = new TreeMap<>();
        for (int i=0; i<nums.length; i++) {
            beforeSort.put(nums[i], beforeSort.getOrDefault(nums[i], 0) + 1);
        }

        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(beforeSort.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                //降序
                // return o2.getValue().compareTo(o1.getValue());

                // 升序
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        ListIterator<Map.Entry<Integer,Integer>> it = list.listIterator();
        // 将排好序的 entry 放入有序映射中
        Map<Integer, Integer> afterSort = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            afterSort.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<Integer, Integer> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    /**
     * 根据字符串长度进行排序
     */
    public static void sortStrings() {
        String[] strs = new String[4];
        strs[0] = "dwefrwf";
        strs[1] = "12w";
        strs[2] = "w212";
        strs[3] = "1we2rwqw2re1e2";

        List<String> strings = new ArrayList<>(Arrays.asList(strs));

        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        for (String s : strings) {
            System.out.print(s + " ");
        }
    }
}
