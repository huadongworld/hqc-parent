package com.ys.hdc.section5.impl;

/**
 * @author HD
 * @date 2018/8/16 8:17
 */
public class Person implements Comparable<Person> {

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public Person(Integer age) {
        this.age = age;
    }

    public Person() {

    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }
}
