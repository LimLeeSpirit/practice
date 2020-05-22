package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode30;


import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        map1.put("q", 1);
        map1.put("w", 2);
        map1.put("e", 3);
        map1.put("r", 4);

        map2.put("r", 4);
        map2.put("e", 3);
        map2.put("w", 2);
        map2.put("q", 1);

        System.out.println(map1.equals(map2));

    }


}
