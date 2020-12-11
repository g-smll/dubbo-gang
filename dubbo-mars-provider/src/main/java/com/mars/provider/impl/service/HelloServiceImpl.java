package com.mars.provider.impl.service;


import com.mars.api.service.HelloService;

/**
 * @author gang.chen
 * @description
 * @time 2020/12/11 9:32
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return name+"，火星计划开始了...";
    }
}
