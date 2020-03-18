package proxymodel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author liutf
 * @date 2020-03-17
 */
public class MyDynamicProxy implements InvocationHandler {
    private Object proxy;

    public MyDynamicProxy(Object proxy) {
        this.proxy = proxy;
    }

    // 代理类实现接口中的一个方法，接收参数分别是被代理的类，要执行的方法，执行方法的参数，返回则是执行方法返回的参数
    // 代理对象的所有方法调用都会转到这个方法中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("dynamic-proxy before");
        Object rTarget = method.invoke(this.proxy, args);
        System.out.println("dynamic-proxy after");
        return rTarget;
    }

    // JDK自带的生成代理类的静态方法，第一个参数是类加载器 第二个参数是被代理类的接口 第三个参数是被代理的对象
    // 这个方法内部的大致原理就是动态的加载这个类，然后放到内存中，所以不是编译时期生成的，是运行的时候生成的
    public static Object proxy(Class interfaceClazz, Object proxy) {
        return Proxy.newProxyInstance(interfaceClazz.getClassLoader(), new Class[]{interfaceClazz},
                new MyDynamicProxy(proxy));
    }
}
