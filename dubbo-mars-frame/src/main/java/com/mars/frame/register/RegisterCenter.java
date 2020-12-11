package com.mars.frame.register;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @author gang.chen
 * @description
 * @time 2020/12/11 9:38
 */
public class RegisterCenter {
    /**
     * String -> 接口名称
     * Map<URL,Class> -> URL（请求地址）/Class(接口实现类)
     */
    private static Map<String, Map<URL,Class>> CENTER = new HashMap<String, Map<URL,Class>>();

    /**
     * ---服务注册的实现---
     * @param interfaceName 接口名称
     * @param url 服务地址
     * @param implClass 接口实现类
     */
    public static void registerService(String interfaceName,URL url, Class implClass){
        Map<URL,Class> map = new HashMap<URL,Class>();
        map.put(url,implClass);
        CENTER.put(interfaceName, map);
    }

    /**
     * @param interfaceName 接口名
     */
    public static Class getServiceImpl(String interfaceName){
        Map<URL, Class> map = CENTER.get(interfaceName);
        return CENTER.get(interfaceName).entrySet().stream().findFirst().get().getValue();
    }
}
