package com.ys.hdc.section9.task;

import java.util.Calendar;

/**
 * @author HD
 * @date 2018/10/9 17:53
 */
public class Task {

    public void doSomething() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        StringBuffer stringBuffer = new StringBuffer();

        //线程名称
        stringBuffer.append("线程名称：" + Thread.currentThread().getName());

        //运行的时间戳
        stringBuffer.append(",执行时间：" + Calendar.getInstance().get(13) + " s");

        System.out.println(stringBuffer);
    }
}
