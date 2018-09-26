package com.ys.hdc.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author HD
 * @date 2018/7/11 8:44
 */
public class Client {

    public static void main(String[] args) {
        try {

            URL url = new URL("http://localhost:8888/");
            URLConnection h = url.openConnection();
            InputStream inputStream=h.getInputStream();
            byte[] buf=new byte[1024];
            int length=0;
            length=inputStream.read(buf);
            System.out.println(new String(buf,0,length));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
