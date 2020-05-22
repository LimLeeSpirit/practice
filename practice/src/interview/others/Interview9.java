package interview.others;

public class Interview9 {
    public static void main(String[] args) {
        System.out.println(getNFactorial(30));
        getNFactorial2(5);
    }
    // 如果 n 比较小，可以这样做，但 n 变大的话，就会溢出
    public static long getNFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("wrong arg");
        }
        if (n == 0) return 1;
        return n * getNFactorial(n - 1);
    }

    // 使用数组保存每一位数
    public static void getNFactorial2(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("wrong arg");
        }
        int num[] = new int[1000];
        int i, j;
        if (n == 1 || n == 0) {
            System.out.println(1);
        } else {
            int nums, h;// nunms 存放当前结果的位数，h 为进位；
            nums = 1;
            h = 0;
            num[1] = 1;
            for (i = 2; i <= n; i ++) {
                // 使得a[]的每位与i相乘
                for (j = 1; j <= nums; j ++) {
                    int tmp = num[j] * i + h;
                    h = tmp / 10;
                    num[j] = tmp % 10;
                }
                // 表示向新的位置进位
                while (h > 0) {
                    num[j] = h % 10;
                    h = h / 10;
                    j ++;
                }
                nums = j - 1;
            }
            for (i = nums; i >= 1; i --) {
                System.out.print(num[i]);
            }
        }
    }
}
