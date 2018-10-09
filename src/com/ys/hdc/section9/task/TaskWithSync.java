package com.ys.hdc.section9.task;

/**
 * @author HD
 * @date 2018/10/9 17:59
 */
public class TaskWithSync extends Task implements Runnable {

    @Override
    public void run() {
        //内部锁
        synchronized ("A") {
            doSomething();
        }
    }
}
