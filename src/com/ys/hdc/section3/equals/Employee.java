package com.ys.hdc.section3.equals;

import java.util.Objects;

/**
 * @author HD
 * @date 2018/8/13 15:08
 */
public class Employee extends Person {

    private int id;

    public Employee(int id) {
        this.id = id;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//        Employee employee = (Employee) o;
//        return id == employee.id;
//    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Employee) {
            Employee employee = (Employee) obj;
            return super.equals(obj) && employee.getId() == id;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    public Employee() {
    }

    public Employee(String name, int id) {
        super(name);
        this.id = id;
    }
}
