package designPattern.singleton;

/**
 * 创建型设计模式
 * 单例模式 双重检查实现方法
 * 　　1、单例类只能有一个实例。
 * 　　2、单例类必须自己创建自己的唯一实例。
 * 　　3、单例类必须给所有其他对象提供这一实例。
 *
 * 实现的时候可以有 懒加载模式、恶汉模式、双重检查等等，懒加载可以保证系统在需要使用的时候才去加载实例、恶汉模式
 * 保证了在编译阶段就完成了单例的加载、双重检查模式保证了线程安全；
 * 实现要求：1、private 级别的构造方法和变量，确保单例不会在系统中的其他代码内被实例化
 *         2、instance 成员变量和 getInstance 方法必须是 staticProxy 的
 *         3、静态成员变量 instance 初始化赋值 null，确保懒加载
 *
 * 意图：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 * 主要解决：一个全局使用的类频繁地创建与销毁。
 * 使用场景：
 *
 * 1、一个班级只有一个班主任。。
 */

public class Singleton {
    // 这里的volatile必须有，头条面试官看来是看过那本书的
    private static volatile Singleton instance = null;
    private Singleton(){
        System.out.println("Simgleton has been loaded");
    }
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();

        System.out.println(Singleton.instance);

        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2);
    }

}


