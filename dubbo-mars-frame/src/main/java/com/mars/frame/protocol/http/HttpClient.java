package com.mars.frame.protocol.http;

import com.mars.frame.invocation.Invocation;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author gang.chen
 * @description
 * @time 2020/12/11 13:47
 */
public class HttpClient {
    /**
     * @param hostName 请求服务名
     * @param port 服务端口
     * @param invocation 请求参数信息
     */
    public String post(String hostName, Integer port, Invocation invocation){
        try {
            URL url = new URL("http",hostName,port,"/");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);

            OutputStream outputStream = httpURLConnection.getOutputStream();

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(invocation);
            objectOutputStream.flush();
            objectOutputStream.close();

            InputStream inputStream = httpURLConnection.getInputStream();
            return IOUtils.toString(inputStream);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
