package algorithm.Aleetcode5_DFS和回溯.leetcode36;

import java.util.*;

public class Test {
    public static void main(String[] args) {

        Set<Map<Integer, Character>> rowSet = new HashSet<>();
        Map<Integer, Character> temp = new HashMap<>();
        Map<Integer, Character> temp2 = new HashMap<>();
        temp.put(2, 'C');
        temp2.put(2, 'C');
        rowSet.add(temp);
        System.out.println(rowSet.isEmpty());
        System.out.println(rowSet.contains(temp2));
        System.out.println("temp 清空前：");
        for(Map<Integer, Character> m: rowSet) {
            Set<Integer> keys = m.keySet();
            Iterator<Integer> iter = keys.iterator();
            while (iter.hasNext())
            {
                Integer key = iter.next();
                System.out.println("key:"+key+" " + "value:"+ m.get(key));

            }
        }

        System.out.println();
        temp.remove(2);
        System.out.println("rowSet 为空："+ rowSet.isEmpty());

        System.out.println("temp 清空后：");
        for(Map<Integer, Character> m: rowSet) {
            Set<Integer> keys = m.keySet();
            Iterator<Integer> iter = keys.iterator();
            while (iter.hasNext())
            {
                Integer key = iter.next();
                System.out.println("key:"+key+" " + "value:"+ m.get(key));

            }
        }
        System.out.println();

        temp.put(3, 'D');
        rowSet.add(temp);
        System.out.println(rowSet.isEmpty());
        System.out.println(rowSet.contains(temp2));

    }
}
