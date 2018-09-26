package com.ys.hdc.section2;

import org.junit.Test;

import java.util.*;

/**
 * @author HD
 * @date 2018/6/26 17:11
 */
public class SectionTwoCodeTest {

    private static final char[] code = new char[]{'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /**
     * 建议21：用偶判断，不用奇判断
     *
     * note: 取余运算的模拟代码：
     *
     * public static int remainder(int dividend, int divisor){
     *     return dividend - dividend / divisor * divisor;
     * }
     *
     */
    @Test
    public void demo01() {
        List<Integer> list = Arrays.asList(1, 2, 0, -1, -2, -3);
        for (int i : list) {
//            String str = i + " -> " + (i % 2 == 1 ? "奇数" : "偶数"); // 负数出错
            String str = i + " -> " + (i % 2 == 0 ? "偶数" : "奇数");
            System.out.println(str);
        }
    }

    /**
     * 建议28：优先使用整形池
     *
     * 装箱生成的对象对于-128~127之间的int转换成Integer对象，直接从整形池（cache数组）中获取，所以导致地址是相同的
     *
     * 而对于超出这个范围的数，装箱是通过new一个对象产生的，地址必然不同
     *
     * 当然，在比较对象是否相等的时候一般使用 equals 而不是 ==
     *
     */
    @Test
    public void demo02() {
        List<Integer> list = Arrays.asList(127, 128, 555);
        for (int i : list) {

            System.out.println("===================== " + i + " 的相等判断=====================");
            Integer a = new Integer(i);
            Integer b = new Integer(i);
            System.out.println("new产生的对象：" + (a == b));

            a = i;
            b = i;
            System.out.println("基本类型转换的对象：" + (a == b));

            i = Integer.valueOf(i);
            b = Integer.valueOf(i);
            System.out.println("valueOf产生的对象：" + (a == b));
        }
    }

    interface B {
        public static final S s = new S() {
            @Override
            public void doSomething() {
                System.out.println("我在接口中实现了");
            }
        };
    }

    interface S {
        /**
         * doSomething（加个注释、强迫症伤不起）
         */
        public void doSomething();
    }

    /**
     * 建议31：接口中可以存在实现代码，但是尽量不要在接口中写实现
     */
    @Test
    public void demo03() {
        B.s.doSomething();
    }

    @Test
    public void demo04() {
        int i = 0;
        while (i++ < 10) {
            System.out.println(getInvitationCode((long) new Random().nextInt(1000)));
        }
    }

    private String getInvitationCode(Long uId) {

        int userId = uId.intValue();
        String hexUserId = Integer.toHexString(userId).toUpperCase();
        while (hexUserId.length() < 4) {
            int index = new Random().nextInt(code.length);
            hexUserId += code[index];
        }
        return hexUserId;
    }
}