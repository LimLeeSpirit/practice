package javadetail.thread;

/**
 * 如果让你说一下java里的锁，可以从悲观锁、乐观锁；可重入锁、不可重入锁；独享锁、共享锁等；自旋锁、偏向锁；
 *
 * 读写锁里state被分为高16位和低16位，分别代表读锁个数和写锁个数
 */
public class ReentrantReadWriteLockTest {
    public static void main(String[] args) {
        int c = 1 << 17;
        // 学到位运算这个写法
        System.out.println("高16位：" + (c >>> 16));
        System.out.println("低16位：" + (c & ((1 << 16) - 1)));
    }
}
