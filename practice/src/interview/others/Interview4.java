package interview.others;

/**
 * 多个线程交替打印123
 */
public class Interview4 {
    public static void main(String[] args) {
        final Object lock1 = new Object();
        final Object lock2 = new Object();
        final Object lock3 = new Object();
        Thread t1 = new Thread(new MultiRunner(lock2, lock1, "thread1: 1"));
        Thread t2 = new Thread(new MultiRunner(lock3, lock2, "thread2: 2"));
        Thread t3 = new Thread(new MultiRunner(lock1, lock3, "thread3: 3"));

        t1.start();
        t2.start();
        t3.start();
    }

}

class MultiRunner implements Runnable {
    volatile int count = 0;
    private final Object next;
    private final Object current;
    private final String message;

    public MultiRunner(Object next, Object current, String message) {
        this.next = next;
        this.current = current;
        this.message = message;
    }

    @Override
    public void run() {
        while (count <= 100) {
            synchronized (next) {
                synchronized (current) {
                    System.out.println(message);
                    count++;
                    // 唤醒等待当前锁的线程
                    current.notifyAll();
                }
                try {
                    // 如果还需要继续执行，则让出下一个线程对应的锁并进入等待状态
                    if (count <= 100) {
                        next.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}