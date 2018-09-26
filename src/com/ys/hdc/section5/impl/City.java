package com.ys.hdc.section5.impl;

import java.util.Objects;

/**
 * @author HD
 * @date 2018/8/15 8:11
 */
public class City implements Comparable<City> {

    private String code;

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(code, city.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    public City(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public City() {
    }

    public String getCode() {

        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(City o) {
        return o.getCode().compareTo(this.code);
    }
}
