package designPattern.proxy;

import designPattern.proxy.impl.UserDao;
import designPattern.proxy.proxys.UserDaoStaticProxy;

public class TestMain {
//    @Test
//    public void testStaticProxy(){
//        //目标对象
//        IUserDao target = new UserDao();
//        //代理对象
//        UserDaoStaticProxy proxy = new UserDaoStaticProxy(target);
//        proxy.save();
//    }

//    @Test
//    public void testJDKProxy (){
//        IUserDao target = new UserDao();
//        System.out.println(target.getClass());  //输出目标对象信息
//        IUserDao proxy = (IUserDao) new UserDaoCglibProxy(target).getProxyInstance();
//        System.out.println(proxy.getClass());  //输出代理对象信息
//        proxy.save();  //执行代理方法
//    }
}
