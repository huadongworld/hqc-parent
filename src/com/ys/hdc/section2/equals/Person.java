package com.ys.hdc.section2.equals;

import java.util.Objects;

/**
 * @author HD
 * @date 2018/7/12 11:31
 */
public class Person {

    private String name;

    private Long id;

    public Person() {
    }

    public Person(String name, Long id) {

        this.name = name;
        this.id = id;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
