package com.ys.hdc.section9.thread;

/**
 * @author HD
 * @date 2018/9/29 18:04
 */
public class ThreadExtendsThread extends Thread {

    @Override
    public void run() {
        System.out.println(this.getClass().getSimpleName() + "线程启动。。。。");
    }
}
