package proxymodel;

/**
 * @author liutf
 * @date 2020-03-17
 */
public class TestMain {
    public static void main(String[] args){
        // 静态代理
        staticProxy();
        System.out.println("-----------");
        // 动态代理
        dynamicProxy();
    }

    /**
     * 静态代理
     */
    public static void staticProxy(){
        TargetImpl targetimpl = new TargetImpl();
        MyStaticProxy staticProxy = new MyStaticProxy(targetimpl);
        staticProxy.doSomething();
    }

    /**
     * 动态代理
     */
    public static void dynamicProxy(){
        Target target = (Target) MyDynamicProxy.proxy(Target.class, new TargetImpl());
        target.doSomething();
    }
}
