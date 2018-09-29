package com.ys.hdc.section8;

import com.sun.jmx.snmp.Timestamp;
import com.ys.hdc.section8.exception.MyException;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HD
 * @date 2018/9/18 8:41
 */
public class SectionEightCodeTest {

    @Test
    public void demo01() {
        Timestamp nowTimestamp = new Timestamp(System.currentTimeMillis());
        System.out.print(nowTimestamp);
    }

    /**
     * 建议110：提倡异常封装
     */
    @Test
    public void demo02() {
        try {
            doStuff();
        } catch (MyException e) {
            //输出所有异常
            e.printMsg();
        }
    }

    private void doStuff() throws MyException {

        List<Throwable> list = new ArrayList<>();

        try {
            //do something
            throw new Exception("抛出异常了111111");
        } catch (Exception e) {
            //异常一
            list.add(e);
        }

        try {
            //do something
            throw new Exception("抛出异常了222222");
        } catch (Exception e) {
            //异常二
            list.add(e);
        }

        if (list.size() > 0) {
            throw new MyException(list);
        }
    }

    @Test
    public void demo03() {

    }
}
