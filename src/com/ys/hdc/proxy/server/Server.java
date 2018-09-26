package com.ys.hdc.proxy.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author HD
 * @date 2018/7/11 8:47
 */
public class Server implements Runnable{

    Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        System.out.println(socket.getInetAddress());
        try {

            InputStream inputStream=socket.getInputStream();
            byte buf[]=new byte[1024];
            int length=0;
            length=inputStream.read(buf);

            System.out.println(new String(buf,0,length));

            OutputStream outputStream=socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println("HTTP/1.1 200 OK\r\n");
            printWriter.print("Date: Sat, 31 Dec 2005 23:59:59 GMT\r\n");
            printWriter.print("Content-Type: text/html;charset=ISO-8859-1\r\n");
            printWriter.println("Content-Length: " + "<html><head></head><body><font size='30' color='red'>你好</font></body></html>".getBytes().length + "\r\n");
            printWriter.println("<html><head></head><body><font size='30' color='red'>你好</font></body></html>");
            printWriter.flush();
            socket.shutdownInput();
            socket.close();

            System.out.println("发送数据成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        while(true)
        {
            Socket socket = serverSocket.accept();
            Thread t = new Thread(new Server(socket));
            t.start();
        }
    }

}