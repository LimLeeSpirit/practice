package designPattern.singleton;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 其实这种才是真正的懒加载、线程安全：
 * 可保证线程安全：调用的是静态内部类，虚拟机会保证一个类的<clinit>()方法在多线程环境中被正确地加锁、同步，如果多个线程同时去初始化一个类，那么只会有一个线程去执行这个类的<clinit>()方法，其他线程都需要阻塞等待，直到活动线程执行<clinit>()方法完毕。
 * 也能保证单例的唯一性：不管多少个线程去调用getInstance()方法，取的都是同一个INSTANCE对象
 * 同时也延迟了单例的实例化：只有在显示调用Singleton2.getInstance方法时，才会去加载静态内部类；
 * 缺点也是有的，由于是用的Singleton2.getInstance这种方式获得单例，所以无法从外面传递参数进去。
 *
 * https://blog.csdn.net/mnb65482/article/details/80458571
 *
 */
public class Singleton2 {
    private Singleton2() {
        System.out.println("lazy load Singleton2 instance");
    }

    // 静态内部类, 对静态域 INSTANCE 延迟加载
    private static class SingletonLoad {
        private static final Singleton2 INSTANCE = new Singleton2();
    }

    public static final Singleton2 getInstance() {
        return SingletonLoad.INSTANCE;
    }

    public static void main(String[] args) {
        // Singleton2 s1 = new Singleton2();

        Singleton2 s2 = Singleton2.getInstance();
        Singleton2 s3 = Singleton2.getInstance();
        Singleton2 s4 = Singleton2.getInstance();


        System.out.println(s2 == s3);
    }
}

class sinle {
    private sinle() {
    }

    public static class loadSingle {
        private static sinle Instance = new sinle();
    }

    public static sinle getInstance() {
        return loadSingle.Instance;

    }

}

/**
 *         Print p = new Print();
 *         FutureTask<Object> f = new FutureTask(p);
 *         Thread t = new Thread(f);
 *         t.start();
 *         f.get();
 */
class Print implements Callable {
    @Override
    public Object call() throws Exception {
        return null;
    }
}
