package com.ys.hdc.section2.api;

/**
 * @author HD
 * @date 2018/6/28 18:06
 */
public abstract class Server {
    public final static int DEFAULT_PORT = 40000;

    public Server() {
        int port = getPort();
        System.out.println("端口号：" + port);
    }

    /**
     * 由子类提供端口号，并做可用性检查
     * @return
     */
    protected abstract int getPort();
}
