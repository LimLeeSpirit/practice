package interview.others;


/**
 * 三个线程交替打印出 1-100
 */
public class Interview5 {
    public static void main(String[] args) {
        final Object lock1 = new Object();
        final Object lock2 = new Object();
        final Object lock3 = new Object();
        Thread t1 = new Thread(new MultiRunners(lock2, lock1));
        Thread t2 = new Thread(new MultiRunners(lock3, lock2));
        Thread t3 = new Thread(new MultiRunners(lock1, lock3));

        t1.start();
        t2.start();
        t3.start();
    }
}

class MultiRunners implements Runnable {
    volatile int count = 0;
    private final Object next;
    private final Object current;

    public MultiRunners(Object next, Object current) {
        this.next = next;
        this.current = current;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (next) {
                synchronized (current) {
                    // 唤醒等待当前锁的线程
                    current.notifyAll();
                    if (count <= 100) {
                        System.out.println(Thread.currentThread().getName() + " :" + count ++);
                    } else {
                        break;
                    }
                }
                try {
                    // 如果还需要继续执行，则让出下一个线程对应的锁并进入等待状态
                        next.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}