package com.mars.frame.servlet;

import com.mars.frame.invocation.Invocation;
import com.mars.frame.register.RegisterCenter;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author gang.chen
 * @description
 * @time 2020/12/11 11:25
 */
public class HttpServerHandler {
    public void handel(HttpServletRequest req, HttpServletResponse resp)
    {
        try {
            ServletInputStream inputStream = req.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Invocation invocation = (Invocation)objectInputStream.readObject();

            //获取接口名->获取接口实现类->sayHello(String name)执行该方法
            String interfaceName = invocation.getInterfaceName();
            Class serviceImpl = RegisterCenter.getServiceImpl(interfaceName);
            Method method = serviceImpl.getMethod(invocation.getMethodName(), invocation.getParamTypes());
            String result = (String)method.invoke(serviceImpl.newInstance(), invocation.getParams());

            //返回处理结果
            ServletOutputStream outputStream = resp.getOutputStream();
            IOUtils.write(result,outputStream);
        }
        catch (IOException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }


    }
}
