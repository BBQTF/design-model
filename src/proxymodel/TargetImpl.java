package proxymodel;

/**
 * @author liutf
 * @date 2020-03-17
 */
public class TargetImpl implements Target {
    @Override
    public void doSomething() {
        System.out.println("我是被代理的方法");
    }
}
