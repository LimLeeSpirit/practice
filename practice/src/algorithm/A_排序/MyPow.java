package algorithm.A_排序;

public class MyPow {
    public static void main(String[] args) {
        System.out.println(pow(3, 4));
    }
    public static int pow(int x, int n) {
        if (n == 1) {
            return x;
        }
        // 奇数
        if ((n & 1) == 1) {
            return x * pow(x, n >> 1) * pow(x, n >> 1);
        } else {
            return pow(x, n >> 1) * pow(x, n >> 1);
        }
    }
}
