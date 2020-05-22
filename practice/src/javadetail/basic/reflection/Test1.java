package javadetail.basic.reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 利用反射进行获得类型，使用到了类型擦除
 */
public class Test1 {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a.add("adc");

        // 1. 对象.getClass()
        Class c = a.getClass();
        // 2. 类.class
        Class arrayList = ArrayList.class;
        // 3. 通过Class的静态方法
        // Class a = Class.forName();
        try{
            Method m = c.getMethod("add", Object.class);
            m.invoke(a, 100);
            m.invoke(a, 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Object b : a) {
            System.out.println(b);
            System.out.println(b.getClass());
        }

    }
}
