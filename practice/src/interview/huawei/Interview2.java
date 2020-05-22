package interview.huawei;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Interview2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int cur_n = in.nextInt();
            Set<Integer> set = new TreeSet<>();
            for (int i = 0; i < cur_n; i ++) {
                set.add(in.nextInt());
            }
            for (int a : set) {
                System.out.println(a);
            }
        }
    }
}
