package com.ys.hdc.section9.thread;

/**
 * @author HD
 * @date 2018/10/8 17:40
 */
public class ThreadImplementsRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(this.getClass().getSimpleName() + "线程启动。。。。");
    }
}
