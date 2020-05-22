package algorithm.Aleetcode8_哈希堆并查集平衡树.leetcode146;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        System.out.println(list);
        list.removeFirst();
        System.out.println(list);

        Solution2  test = new Solution2(2); //  null
        System.out.println(test.get(2));            // -1
        test.put(2, 6);                             // null
        System.out.println(test.get(1));            // -1

        test.put(1, 5);                             // null
        test.put(1, 2);                             // null
        System.out.println(test.get(1));            // -1
        System.out.println(test.get(2));            // 6 结果成了 -1

    }
}
