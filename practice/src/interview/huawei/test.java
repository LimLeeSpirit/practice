package interview.huawei;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ss = in.nextLine();
        int N = ss.charAt(0) - '0';
        int M = ss.charAt(2) - '0';
        int[] nums = new int[N];
        String num = in.nextLine();
        System.out.println(num);
        for (int i = 0; i < N; i ++) {
            nums[i] = num.charAt(i * 2) - '0';
        }
        int K = (int)Math.sqrt(N);
        int[] max = new int[K];  // 9->3; 14->3
        for (int i = 0; i < M; i ++) {
            String s = in.nextLine();
            System.out.println(s);
        }
    }
}
