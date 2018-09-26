package com.ys.hdc.section2.impl;

import com.ys.hdc.section2.api.Server;

/**
 * @author HD
 * @date 2018/6/28 18:20
 */
public class SimpleServer extends Server {

    private int port = 100;

    public SimpleServer(int port) {
        this.port = port;
    }

    @Override
    protected int getPort() {
        return Math.random() > 0.5 ? port : DEFAULT_PORT;
    }
}
