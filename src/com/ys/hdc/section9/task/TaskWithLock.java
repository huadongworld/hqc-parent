package com.ys.hdc.section9.task;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author HD
 * @date 2018/10/9 17:57
 */
public class TaskWithLock extends Task implements Runnable {

    private final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            //加锁
            lock.lock();
            doSomething();
        } finally {
            //释放锁
            lock.unlock();
        }
    }
}
