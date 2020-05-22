package algorithm.Aleetcode10_数组.二维数组旋转;

/**
 * 对二维数组进行 逆时针旋转45度，然后从左往右从上到下输出打印。
 *
 * 1， 2， 3， 4
 * 5， 6， 7， 8
 * 9，10，11，12
 * 13，14，15，16
 *
 * 输出：
 * 4
 * 3，8
 * 2，7，12
 * 1，6，11，16
 * 5，10，15
 * 9，14
 * 13
 *
 * 这个题如果想一个双for循环是写不出的，我最开始就卡壳卡在这了。因为i，j不是一直保持同一个走向的。
 * 这里就只有拆开来做，分别输出右上角和左下角。
 */
public class RotateArrays {
    public static void rotateArrays(int[][] nums) {
        int m, n;
        int len = nums.length;

        // 打印右上角
        for (int i = len - 1; i >= 0; i --) {
            m = 0;
            n = i;
            while (n < len) {
                System.out.print(nums[m++][n++] + " ");
            }
            System.out.println();
        }

        // 打印左下角
        for (int j = 1; j < len; j ++) {
            m = j;
            n = 0;
            while (m < len) {
                System.out.print(nums[m ++][n ++] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
    }
}
