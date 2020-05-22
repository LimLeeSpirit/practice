package designPattern.proxy.proxys;

import java.lang.reflect.Method;

//import net.sf.cglib.proxy.Enhancer;
//import net.sf.cglib.proxy.MethodInterceptor;
//import net.sf.cglib.proxy.MethodProxy;
//
//public class UserDaoCglibProxy implements MethodInterceptor {
//    private Object object;
//
//    public UserDaoCglibProxy(Object object) {
//        this.object = object;
//    }
//
//    public Object getProxyInstance() {
//        Enhancer enhancer = new Enhancer();
//        en.setSuperclass(object.getClass());
//        //设置回调函数
//        en.setCallback(this);
//        //创建子类对象代理
//        return en.create();
//    }
//
//    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
//        System.out.println("开启事务");
//        // 执行目标对象的方法
//        Object returnValue = method.invoke(object, args);
//        System.out.println("关闭事务");
//        return null;
//    }
//}
