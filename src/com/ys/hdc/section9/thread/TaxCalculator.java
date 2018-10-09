package com.ys.hdc.section9.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author HD
 * @date 2018/10/9 16:59
 */
public class TaxCalculator implements Callable<Integer> {

    private Integer seedMoney;

    public TaxCalculator(Integer seedMoney) {
        this.seedMoney = seedMoney;
    }

    @Override
    public Integer call() throws Exception {
        TimeUnit.MILLISECONDS.sleep(1000);
        return seedMoney / 10;
    }
}
