package com.ys.hdc.section7;

import com.ys.hdc.section7.proxy.RealSubject;
import com.ys.hdc.section7.proxy.Subject;
import com.ys.hdc.section7.proxy.SubjectHandler;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;

/**
 * @author HD
 * @date 2018/9/17 8:08
 */
public class SectionSevenCodeTest {

    @Test
    public void demo01() {

        List<String> list = Arrays.asList("1", "2", "3");

        //Arrays.asList 不可变，以下代码报错
        //list.add("4");
    }

    /**
     * 建议96：不同场景使用不同的泛型通配符
     * java泛型支持通配符，可以单独一个"?"表示任意类，也可以使用extends关键字表示某一个类（接口）的子类型，还可以使用super关键字表示某一个类的父类型
     * 什么时候用extends，什么时候该用super呢?
     */
    @Test
    public void demo02() {

        //（1）泛型结构只参与“读”操作则限定上界（extends关键字），例如：read()方法，?表示E类的子类，即该方法所有的E类的子类list都能够传进来

        //（2）泛型结构只参与“写”操作则限定下界（super关键字），例如：write()方法，?表示Number的父类，即该方法所有基类中有number的都能够传进来
    }

    public static <E> void read(List<? extends E> list) {
        for (E e : list) {
            //进行业务操作
        }
    }

    public static void write(List<? super Number> list) {
        list.add(123);
        list.add(1.23);
    }

    /**
     * 建议97：警惕泛型是不能够协变和逆变的，协变：窄类型替换宽类型（例如：子类对象赋值给父类引用），逆变：宽类型替换窄类型（没有太大意义，例如：方法重载参数逆变）
     */
    @Test
    public void demo03() {

    }


    /**
     * 建议98：采用顺序List<T>、List<?>、List<Object>
     * （1）List<T>是确定的某一个类型，可读可写
     * （2）List<?>只读，读出的元素是Object类型
     * （3）List<Object>可读写，写入时需要向上转型，读取后需要向下转型
     */
    @Test
    public void demo04() {

    }

    /**
     * 建议99：使用“&”符号设定多重边界
     */
    @Test
    public void demo05() {

    }

    interface Staff{
        int getSalary();
    }

    interface Passenger {
        boolean isStanding();
    }

    public static <T extends Staff & Passenger> void discount(T t) {
        if (t.getSalary() < 2500 && t.isStanding()) {
            System.out.println("恭喜你！你的车票八折！");
        }
    }

    /**
     * 建议101：注意Class类的特殊性
     */
    @Test
    public void demo06() {
        //1.无构造函数
        //2.可以描述基本类型
        //3.其对象都是单例模式
        //4.Class类是反射的入口，获取Class对象有三种途径：
        //（1）类属性方法，如String.class
        //（2）对象的getClass方法，如new String().getClass()
        //（3）forName方法加载，如Class.forName("java.lang.String").
        //5.获得了Class对象后，就可以通过getAnnotation()获得注解，通过getMethods()获得方法，通过getConstructors()获得构造函数
    }

    /**
     * 建议106：动态代理可以使代理模式更加灵活（不太懂）
     */
    public void demo07() {

        //被代理类
        Subject subject = new RealSubject();
        //代理实例的处理Handler
        InvocationHandler invocationHandler = new SubjectHandler(subject);
        //当前加载器
        ClassLoader classLoader = subject.getClass().getClassLoader();
        //动态代理
        Subject s = (Subject) Proxy.newProxyInstance(classLoader, subject.getClass().getInterfaces(), invocationHandler);
        //执行具体主题角色方法
        s.request();
    }
}
