package javadetail.thread;

/**
 * 查看 ThreadLocal 源码
 * 0：作用
 *    为每个线程存储某个变量的副本，即每个线程内部都会有一个该变量，
 *    且在线程内部任何地方都可以使用，线程之间互不影响，
 *    这样一来就不存在线程安全问题，也不会严重影响程序执行性能。
 *    这个变量可以是 数据库链接
 * 1：用法
 * 主要有几个方法， 对于每个 ThreadLocal变量，有set、get、remove、initialValue方法，
 * get方法是用来获取 ThreadLocal 变量在当前线程中保存的变量副本
 * set用来设置当前线程中 ThreadLocal 变量的副本
 * remove用来移除当前线程中变量的副本
 * initialValue()是一个protected方法，一般是用来在使用时进行重写的，它是一个延迟加载方法
 *
 * 2：原理
 * 在每个线程Thread内部有一个ThreadLocal.ThreadLocalMap类型的成员变量threadLocals，
 * 这个threadLocals就是用来存储实际的变量副本的，键值为当前ThreadLocal变量，value为变量副本（即T类型的变量）。
 *
 * 初始时，在Thread里面，threadLocals为空，当通过ThreadLocal变量调用get()方法或者set()方法，
 * 就会对Thread类中的threadLocals进行初始化，并且以当前ThreadLocal变量为键值，
 * 以ThreadLocal要保存的副本变量为value，存到threadLocals。
 *
 * 然后在当前线程里面，如果要使用副本变量，就可以通过get方法在threadLocals里面查找。
 *
 *【注意】这个 ThreadLocalMap 类并没有实现 Map 接口，而是一个定制的散列映射，仅适用于维护线程本地值。
 * 其hash冲突也简单的多，不是使用hashmap的链式/二叉树解决办法，二是简单的线性探测法。
 * entry 对象使用 WeakReferences 作为键。所以这里会产生一个"内存泄漏"的问题：
 * ThreadLocal 变量在没有外部对象强引用时，发生GC时弱引用Key会被回收，而Value不会回收，
 * 如果创建ThreadLocal的线程一直持续运行，那么这个Entry对象中的value就有可能一直得不到回收，发生内存泄露。
 * 解决办法是在调用 ThreadLocal 变量的get()、set()方法时完成后再调用其remove方法，将Entry节点和Map的引用关系移除，
 * 这样整个Entry对象在GC Roots分析后就变成不可达了，下次GC的时候就可以被回收。
 *
 *
 * 3：使用场景
 * 访问数据库、session会话
 *
 * 每个线程访问数据库都应当是一个独立的Session会话，如果多个线程共享同一个Session会话，有可能其他线程关闭连接了，
 * 当前线程再执行提交时就会出现会话已关闭的异常，导致系统异常。
 * 此方式能避免线程争抢Session，提高并发下的安全性。
 *
 * 使用ThreadLocal的典型场景正如上面的数据库连接管理、线程会话管理等场景；
 * 只适用于独立变量副本的情况，每个线程的使用互不相干互相隔离。
 */
public class threadLocalTest {
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();

    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    // 用完之后将本地变量删除掉，不然容易造成内存泄漏，key为weakReference，value为强引用
    public void removeLongLocal() {
        longLocal.remove();
    }

    public void removeStringLocal() {
        stringLocal.remove();
    }

    public static void main(String[] args) throws InterruptedException {
        final threadLocalTest test = new threadLocalTest();

        test.set();
        System.out.println(Thread.currentThread().getName() + " :" + test.getLong());
        System.out.println(Thread.currentThread().getName() + " :" + test.getString());


        Thread thread1 = new Thread(){
            public void run() {
                test.set();
                System.out.println(test.getLong());
                System.out.println(test.getString());
            }
        };
        thread1.start();
        thread1.join();

        System.out.println(test.getLong());
        System.out.println(test.getString());
    }
}
