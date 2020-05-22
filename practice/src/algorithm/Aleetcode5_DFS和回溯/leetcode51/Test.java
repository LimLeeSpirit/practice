package algorithm.Aleetcode5_DFS和回溯.leetcode51;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        // 注意点2：
        List<List<Integer>> test = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);

        List<Integer> b = new ArrayList<>();
        b.add(4);
        b.add(5);
        b.add(6);

        test.add(a);
        test.add(b);

        for (List e: test) {
            for(Object o: e) {
                // 这里为何是Object类型？？？
                // 在没有泛型类时，原始的ArrayList类提供的get方法返回的只能是Object类型，get方法调用者必须对返回值进行
                // 类型转换。
                System.out.println((int)o);
            }
            System.out.println("----------");
        }

        // 写成下面的形式就没问题了。
        for (List<Integer> e: test) {
            for(int o: e) {
                System.out.println(o);
            }
            System.out.println("----------");
        }


        System.out.println("swq");

//
//        List<List<String>> re = MyStack.solveNQueens(4);
//        for (List c: re) {
//            System.out.println(c.size());
//            for(Object s: c) {
//                System.out.println(s);
//            }
//            System.out.println("-----下一个解法-----");
//        }

        // ArrayList 这个动态数组列表，自动扩容，也容易产生很多问题，那就是 ArrayList 的 add 和 set 方法可以添加任意类型的对象。
        List<Object> a1 = new ArrayList<>();
        a1.add(3);
        a1.add("21");
        for(Object o: a1) {
            System.out.println(o);
        }
    }
}
