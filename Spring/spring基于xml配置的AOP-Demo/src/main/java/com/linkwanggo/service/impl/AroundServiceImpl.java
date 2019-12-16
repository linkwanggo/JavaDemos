package com.linkwanggo.service.impl;

import com.linkwanggo.service.IAroundService;

public class AroundServiceImpl implements IAroundService {

    public int aroundMethod(int arg) {
//        int i = 1 / 0;
        System.out.println("AroundServiceImpl执行了环绕方法");
        return 0;
    }
}
