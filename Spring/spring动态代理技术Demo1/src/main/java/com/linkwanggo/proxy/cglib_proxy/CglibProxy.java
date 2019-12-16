package com.linkwanggo.proxy.cglib_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 模拟一个消费者
 */
public class CglibProxy {
    /**
     * 动态代理：
     *  特点：字节码随用随创建，随用随加载
     *  作用：不修改源码的基础上对方法增强
     *  分类：
     *      基于接口的动态代理
     *      基于子类的动态代理
     *  基于子类的动态代理：
     *      涉及的类：Enhancer
     *      提供者：第三方cglib库
     *  如何创建代理对象：
     *      使用Enhancer类中的create方法
     *  创建代理对象的要求：
     *      被代理类不能是最终类
     *  create方法的参数：
     *      Class：字节码
     *          它是用于指定被代理对象的字节码。
     *
     *      Callback：用于提供增强的代码
     *          它是让我们写如何代理。我们一般都是些一个该接口的实现类，通常情况下都是匿名内部类，但不是必须的。
     *          此接口的实现类都是谁用谁写。
     *          我们一般写的都是该接口的子接口实现类：MethodInterceptor
     */
    public static void main(String[] args) {
        Producer producer = new Producer();
        Producer producerProxy = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy)
                    throws Throwable {
                // 定义返回结果
                Object res = null;
                // 获取方法执行的参数
                Float money = (Float) args[0];
                // 增强销售方法
                if (method.getName().equals("saleProduct")) {
                    res = method.invoke(producer, money * 0.8f);
                }
                return res;
            }
        });
        System.out.println("支付给代理商10000元");
        producerProxy.saleProduct(10000f);
    }
}
