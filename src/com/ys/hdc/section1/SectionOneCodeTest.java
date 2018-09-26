package com.ys.hdc.section1;

import org.junit.Test;

import java.util.Date;
import java.util.HashSet;

/**
 * @author HD
 * @date 2018/6/25 18:35
 */
public class SectionOneCodeTest {

    /**
     * 建议3：三元操作符的类型务必一致
     */
    @Test
    public void demo01() {
        int i = 80;
        String s = String.valueOf(i < 100 ? 90 : 100);
        String s2 = String.valueOf(i < 100 ? 90 : 100.0);
        //false
        System.out.println(s.equals(s2));
    }

    /**
     * 建议7：警惕自增陷阱
     */
    @Test
    public void demo02() {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            count = count++;
        }
        //0
        System.out.println(count);
    }

    /**
     * 建议18：避免instanceof非预期结果
     */
    @Test
    public void demo03() {
//        Boolean b = new Date() instanceof String;   编译通不过
        Boolean b = "" instanceof String;
        System.out.println(b);
    }

    /**
     * 建议19：断言绝对不是鸡肋
     */
    @Test
    public void demo04() {
        int i = 7;
        while (i > 7) {
        }
        assert false : "错误！";

//        String name = "abner chai";
        String name = null;
        assert (name != null) : "变量name为空null";
        System.out.println(name);
    }

    @Test
    public void demo05() {
        for (int i = 98765; i >= 48382; i--) {

            int tranNum = trans(i);
            double divisor = (double) i / tranNum;
            if (tranNum != 0 && isIntegerForDouble(divisor) && checkIsRepeat(i)) {
                System.out.println(i);
                System.out.println(i / tranNum);
                System.out.println(tranNum);
                System.out.println("-------------------------");
            }

        }
    }

    private int trans(int num) {

        int result = 0;
        while(true)
        {
            int n = num % 10;
            result = result * 10 + n;
            num = num / 10;
            if (num == 0) {
                break;
            }
        }
        return result;
    }

    private boolean checkIsRepeat(int num) {

        int[] array = tranIntToArr(num);

        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < array.length; i++) {
            hashSet.add(array[i]);
        }
        if (hashSet.size() == array.length) {
            return true;
        } else {
            return false;
        }
    }

    private int[] tranIntToArr(int num) {

        String str = String.valueOf(num);
        int[] intArray = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            intArray[i] = Integer.parseInt(ch.toString());
        }
        return intArray;
    }

    private static boolean isIntegerForDouble(double obj) {
        double eps = 1e-10;
        return obj-Math.floor(obj) < eps;
    }

    @Test
    public void demo06() {
        int[] arr = tranIntToArr(123456);
        System.out.println(arr);
    }

}
