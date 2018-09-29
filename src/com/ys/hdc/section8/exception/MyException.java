package com.ys.hdc.section8.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HD
 * @date 2018/9/18 8:56
 * 一次性抛出多个异常
 */
public class MyException extends Exception {

    private List<Throwable> cause = new ArrayList<>();

    public MyException(List<? extends Throwable> list) {
        cause.addAll(list);
    }

    public List<Throwable> getException() {
        return cause;
    }

    public void printMsg() {
        cause
                .stream()
                .map(Throwable::getMessage)
                .forEach(System.out::println);

    }
}
