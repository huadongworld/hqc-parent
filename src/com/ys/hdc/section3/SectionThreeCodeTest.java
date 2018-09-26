package com.ys.hdc.section3;

import com.ys.hdc.section3.equals.Employee;
import com.ys.hdc.section3.equals.Person;
import com.ys.hdc.section5.impl.City;
import org.junit.Test;

import java.util.*;

/**
 * @author HD
 * @date 2018/8/13 15:03
 */
public class SectionThreeCodeTest {
    @Test
    public void demo01() {

        Person p1 = new Person("张三");
        Person p2 = new Person(null);

        List<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        System.out.println(people.contains(p1));
        System.out.println(people.contains(p2));
    }

    /**
     * 建议47：在equals中使用getClass进行类型判断
     */
    @Test
    public void demo02() {

        Employee employee1 = new Employee("张三", 1000);
        Employee employee2 = new Employee("张三", 1001);
        Person person = new Person("张三");

        System.out.println(person.equals(employee1));
        System.out.println(person.equals(employee2));
        System.out.println(employee1.equals(employee2));
    }

    @Test
    public void demo03() {

        Map<Person, Object> map = new HashMap<Person, Object>() {
            {
                put(new Person("张三"), new Object());
            }
        };

        List<Person> people = new ArrayList<Person>() {
            {
                add(new Person("张三"));
            }
        };

        boolean b1 = people.contains(new Person("张三"));
        boolean b2 = map.containsKey(new Person("张三"));//如果没有覆写hashCode方法这个将会判断为false，因为hashMap的底层处理机制
    }

    /**
     * 使用package-info类为包服务，全包注解、注释，全包共享变量
     */
    @Test
    public void demo04() {

    }
}
