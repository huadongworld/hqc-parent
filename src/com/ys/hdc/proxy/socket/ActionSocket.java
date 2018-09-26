package com.ys.hdc.proxy.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

/**
 * @author HD
 * @date 2018/7/10 21:27
 */
public class ActionSocket extends Thread {

    private Socket socket = null;

    public ActionSocket(Socket s) {
        this.socket = s;
    }

    public ActionSocket() {
    }

    @Override
    public void run() {
        try {
            this.action();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void action() throws Exception {

        if (this.socket == null) {
            return;
        }
        InputStream cis = this.socket.getInputStream();

        URL url = new URL("http://www.baidu.com");
        HttpURLConnection action = (HttpURLConnection) url.openConnection();
        InputStream sis = action.getInputStream();
        OutputStream cos = socket.getOutputStream();
        int length;
        byte bytes[] = new byte[1024];

        while (true) {
            try {
                if ((length = sis.read(bytes)) > 0) {

                    //将http请求头写到目标主机
                    cos.write(bytes, 0, length);
                    System.out.println(new String(bytes));
                    cos.flush();
                } else if (length < 0) {
                    System.out.println("发送数据成功");
                    break;
                }
            } catch (Exception e) {

            }
        }
        socket.close();
        cis.close();
    }
}
