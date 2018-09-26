package com.ys.hdc.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

/**
 * @author HD
 * @date 2018/7/10 21:48
 */
public class ProxyTest{

    public static void main(String args[])throws Exception{

        Proxy proxy = null;

        // 实例化本地代理对象，端口为8888
        proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 8888));
        URL url = new URL("http://127.0.0.1:8080");

        //使用代理打开网页
        HttpURLConnection action = (HttpURLConnection) url.openConnection(proxy);
        InputStream in = action.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        StringBuilder sb = new StringBuilder();

        String lin = System.getProperty("line.separator");
        for (String temp = br.readLine(); temp != null; temp = br.readLine()) {
            sb.append(temp + lin);
        }
        br.close();
        in.close();

        System.out.println(sb);
    }
}

