package interview.huawei;

import java.util.Scanner;

public class Interview1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int k = in.nextInt();
            if (k == 0) break;
            System.out.println(k);
            System.out.println(printN(k));
        }
    }

    /**
     * 如果num > 2,则可以整除3，=2则刚好可以换一个瓶子，<2 则忽略
     * @param num
     */
    public static int printN(int num) {
        if (num < 2) return 0;
        else if (num == 2) return 1;
        else return num / 3 + printN(num / 3 + num % 3);
    }
}
