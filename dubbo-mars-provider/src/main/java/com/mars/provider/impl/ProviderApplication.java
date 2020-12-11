package com.mars.provider.impl;

import com.mars.api.service.HelloService;
import com.mars.frame.protocol.http.HttpServer;
import com.mars.frame.register.RegisterCenter;
import com.mars.frame.register.URL;
import com.mars.provider.impl.service.HelloServiceImpl;

/**
 * @author gang.chen
 * @description
 * @time 2020/12/11 12:51
 */
public class ProviderApplication {
    public static void main(String[] args) {
        // 注册服务
        URL url = new URL("localhost",8080);
        RegisterCenter.registerService(HelloService.class.getName(),url, HelloServiceImpl.class);

        // 启动tomcat
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHostname(),url.getPort());

    }
}
