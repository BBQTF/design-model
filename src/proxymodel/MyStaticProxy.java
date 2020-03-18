package proxymodel;

/**
 * 静态代理模式
 *
 * @author liutf
 * @date 2020-03-17
 */
public class MyStaticProxy implements Target{
    private Target baseObject; // 声明一个接口类型属性，被代理类只要实现了这个接口就可以使用这个代理类进行代理操作了

    public MyStaticProxy(Target baseObject) {
        this.baseObject = baseObject;
    }

    @Override
    public void doSomething(){
        System.out.println("static-proxy before");
        baseObject.doSomething();
        System.out.println("static-proxy after");
    }
}
