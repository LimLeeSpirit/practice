package interview.alibaba;

/**
 * 实现栈溢出
 * 一个线程申请的虚拟机栈深度大于JVM允许的栈深度，就会抛出栈溢出异常
 * 可以使用参数：
 * -Xss<size>[g|G|m|M|k|K]  来改变JVM栈深度
 */
public class StackOverFlow {
    public static void main(String[] args) {
        dfs();
    }
    private static void dfs() {
        while (true) {
            dfs();
        }
    }
}
