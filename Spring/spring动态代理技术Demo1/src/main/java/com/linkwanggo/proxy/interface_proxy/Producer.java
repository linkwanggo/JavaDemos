package com.linkwanggo.proxy.interface_proxy;

/**
 * 一个生产者实例
 */
public class Producer implements IProducer {

    public void saleProduct(float money) {
        System.out.println("销售电脑，厂商获得：" + money + "元");
    }

    public void afterService(float money) {

    }
}
