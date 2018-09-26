package com.ys.hdc.section7.proxy;

/**
 * @author HD
 * @date 2018/9/17 20:55
 * 静态代理
 */
public class StaticProxy implements Subject {

    @Override
    public void request() {
        before();
        this.subject.request();
        after();
    }

    /**
     * 预处理
     */
    private void before() {
        System.out.println("before.....");
    }

    /**
     * 后处理
     */
    private void after() {
        System.out.println("after.....");
    }

    private Subject subject = null;

    public StaticProxy() {
        this.subject = new RealSubject();
    }

    public StaticProxy(Subject subject) {
        this.subject = subject;
    }
}
