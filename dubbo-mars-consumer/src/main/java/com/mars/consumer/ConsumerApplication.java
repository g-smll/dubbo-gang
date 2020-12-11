package com.mars.consumer;


import com.mars.api.service.HelloService;
import com.mars.frame.invocation.Invocation;
import com.mars.frame.protocol.http.HttpClient;

/**
 * @author gang.chen
 * @description
 * @time 2020/12/11 13:59
 */
public class ConsumerApplication {
    public static void main(String[] args) {
        //创建HttpClient
        HttpClient httpClient = new HttpClient();

        //网络传输对象
        Invocation invocation = new Invocation(HelloService.class.getName(),"sayHello",new Object[]{"gang.chen"},new Class[]{String.class});

        //返回处理结果
        String result = httpClient.post("localhost", 8080, invocation);

        //控制台输出内容
        System.out.println(result);
    }
}
