package com.ys.hdc.section3.equals;

/**
 * @author HD
 * @date 2018/7/12 11:31
 */
public class Person {

    private String name;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return Objects.equals(name, person.name);
//    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person person = (Person) obj;
            if (person.getName() == null || name == null) {
                return false;
            } else {
                return name.equalsIgnoreCase(person.getName());
            }
        }
        return false;
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name);
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }
}
