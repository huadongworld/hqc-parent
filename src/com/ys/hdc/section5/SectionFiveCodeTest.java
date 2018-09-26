package com.ys.hdc.section5;

import com.ys.hdc.section5.impl.City;
import com.ys.hdc.section5.impl.Person;
import org.junit.Test;

import java.util.*;

/**
 * @author HD
 * @date 2018/8/13 20:10
 */
public class SectionFiveCodeTest {

    /**
     * 建议63：在明确的场景下，为集合指定初始容量
     */
    @Test
    public void demo01() {

        //默认初始容量是10，默认按1.5倍扩容，每次扩容会很耗时间耗内存，所以可以明确指定初始容量的话尽量指定初始容量
        List<String> strings = new ArrayList<>();

        //默认初始容量是10，若设置了递增步长，按照步长增长，否则每次扩容两倍
        Vector<String> vector = new Vector<>();
    }

    /**
     * 建议65：避开基本类型数组转换列表陷阱
     *
     * 建议66：asList产生的List对象不可更改
     */
    @Test
    public void demo02() {

        //原始类型数组不能作为asList的输入参数，否则会引起程序逻辑混乱

        //输出1
        int[] data = {1, 2, 3, 4, 5};
        List list = Arrays.asList(data);
        System.out.println(list.size());

        //输出5
        Integer[] data1 = {1, 2, 3, 4, 5};
        List list1 = Arrays.asList(data1);
        System.out.println(list1.size());

        list1.add(6);//无效，报：java.lang.UnsupportedOperationException异常
        System.out.println(list1);
    }

    /**
     * 建议70：子列表只是原列表的一个视图
     */
    @Test
    public void demo03() {
        List<String> strings = new ArrayList<>();
        strings.add("A");
        List<String> strings1 = strings.subList(0, strings.size());
        strings1.add("B");
        System.out.println(strings.equals(strings1));
    }

    /**
     * indexOf依赖equals方法查找，binarySearch依赖compareTo方法查找
     *
     * equals是判断元素是否相等，compareTo是判断元素在排序中的位置是否相同
     */
    @Test
    public void demo05() {
        List<City> cities = new ArrayList<>();
        cities.add(new City("021", "上海"));
        cities.add(new City("021", "沪"));
        Collections.sort(cities);
        City city = new City("021", "沪");

        int index1 = cities.indexOf(city);
        int index2 = Collections.binarySearch(cities, city);
        System.out.println(index1);
        System.out.println(index2);
    }

    /**
     * 建议76：集合运算时使用更优雅的方式
     *
     * 建议77：使用shuffle打乱列表的顺序
     */
    @Test
    public void demo06() {

        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        System.out.println(list1);
        List<String> list2 = new ArrayList<>();
        list2.add("B");
        list2.add("C");
        System.out.println(list2);

        //并集
        list1.addAll(list2);
        System.out.println("并集：" + list1);

        //交集
        list1.retainAll(list2);
        System.out.println("交集：" + list1);

        //差集
        list1.removeAll(list2);
        System.out.println("差集：" + list1);

        //无重复的并集
        List<String> list3 = new ArrayList<>();
        list3.add("A");
        list3.add("B");
        System.out.println(list1);
        List<String> list4 = new ArrayList<>();
        list4.add("B");
        list4.add("C");

        list4.removeAll(list3);
        list4.addAll(list3);
        System.out.println("无重复的并集：" + list4);

        //打乱集合的顺序
        Collections.shuffle(list4);
        System.out.println(list4);
    }

    @Test
    public void demo07() {
        Map<String, String> map = new HashMap<>();
        final Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new Thread(){
            @Override
            public void run() {
                StringBuilder stringBuilder = new StringBuilder();
                long heapMaxSize = runtime.maxMemory() >> 20;
                stringBuilder.append("最大可用内存：" + heapMaxSize + "M\n");
                long total = runtime.totalMemory() >> 20;
                stringBuilder.append("堆内存大小：" + total + "M\n");
                long free = runtime.freeMemory() >> 20;
                stringBuilder.append("空闲内存：" + free + "M");
                System.out.println(stringBuilder);
            }
        });
        for (int i = 0; i < 393217; i++) {
            map.put("key" + i, "value" + i);
        }
    }

    /**
     * 建议81：TreeSet重排序，非稳定排序推荐使用List
     */
    @Test
    public void demo08() {

        TreeSet<Person> people = new TreeSet<Person>();
        people.add(new Person(180));
        people.add(new Person(175));
        people.add(new Person(195));

        for (Person p : people) {
            System.out.println("身高：" + p.getAge());
        }

        people.first().setAge(185);
        for (Person p : people) {
            System.out.println("身高：" + p.getAge());
        }

        //需要使用List彻底重构掉TreeSet
        people = new TreeSet<>(new ArrayList<>(people));
        for (Person p : people) {
            System.out.println("身高：" + p.getAge());
        }
    }
}
