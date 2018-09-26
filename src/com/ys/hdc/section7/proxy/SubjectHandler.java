package com.ys.hdc.section7.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author HD
 * @date 2018/9/17 21:20
 * 动态代理
 */
public class SubjectHandler implements InvocationHandler {

    private Subject subject;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("预处理");
        Object obj = method.invoke(subject, args);
        System.out.println("后处理");
        return obj;
    }

    public SubjectHandler(Subject subject) {
        this.subject = subject;
    }
}
