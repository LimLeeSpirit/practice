package designPattern.proxy.proxys;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserDaoJDKProxy {
    private Object object;

    public UserDaoJDKProxy(Object object) {
        this.object = object;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开启事务");

                        // 执行目标对象方法
                        Object returnValue = method.invoke(object, args);

                        System.out.println("提交事务");
                        return null;
                    }
                });
    }
}
