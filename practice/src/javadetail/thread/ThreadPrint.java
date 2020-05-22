package javadetail.thread;

public class ThreadPrint{
    public static void main(String[] args){
        Print2 p = new Print2();
        Thread t1 = new Thread(p,"thread1");
        Thread t2 = new Thread(p,"thread2");
        t1.start();
        t2.start();
    }
}

class Print2 implements Runnable {
    private volatile int cur;
    public void run() {
        synchronized (this) {
            while (true) {
                // 唤醒其他线程，让其有机会竞争同步控制自愿
                notify();
                if (cur <= 20) {
                    System.out.println(Thread.currentThread().getName() + ":" + cur ++);
                } else {
                    break;
                }
                // 本线程打印了一次之后，进入等待，放弃同步资源，让其他线程去抢占cpu slice，所以需要在线程开始时先唤醒
                try {
                    wait();
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
