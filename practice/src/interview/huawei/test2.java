package interview.huawei;

import java.util.Scanner;

/**
 * 5 7
 * 1 2 3 4 5
 * Q 1 5
 * U 3 6
 * Q 3 4
 * Q 4 5
 * U 4 5
 * U 2 9
 * Q 1 5
 *
 * 这个输入，这种也不行，还是要靠nextLine()
 */
public class test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int N = in.nextInt();
            int M = in.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i ++) {
                nums[i] = in.nextInt();
            }
            for (int i = 0; i < M; i ++) {
                String s = in.nextLine();
                System.out.println(s);
            }
        }

    }
}
