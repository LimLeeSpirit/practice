package javadetail.thread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 实现两个线程，交替打印出1-20
 */
public class ThreadPrint2 {
    public static void main(String[] args) {
        Print p = new Print();
        Thread t1 = new Thread(p, "thread1");
        Thread t2 = new Thread(p, "thread2");
        t1.start();
        t2.start();
    }
}

class Print implements Runnable {
    int num = 1;

    @Override
    public void run() {
        //  用 this 代表的是对象锁，即多个线程调用同一个对象(new Print())的这个run方法的时候，只有一个线程可以执行，其他的阻塞
        synchronized (this) {
            while (true) {
                notify();
                if (num <= 20) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + num ++);
                } else {
                    break;
                }

                // wait  notify 只能在同步控制块或者同步控制方法里面使用
                try {
                    wait();
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
//        Lock l = new ReentrantLock(true);
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(4, 6, 10, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
    }
}