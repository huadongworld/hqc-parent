package com.ys.hdc.section4;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @author HD
 * @date 2018/8/13 16:48
 */
public class SectionFourCodeTest {

    /**
     * 建议52：推荐使用String直接量赋值，因为String字符串是最经常使用的类型，所以String有个常量池的概念
     */
    @Test
    public void demo01() {

    }

    /**
     * 编码
     */
    @Test
    public void demo02() throws UnsupportedEncodingException {
        String string = "汉字";
        byte[] bytes = string.getBytes("UTF-8");
        System.out.println(new String(bytes));
    }
}
