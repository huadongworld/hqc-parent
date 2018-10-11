package com.ys.hdc.section9;

import com.ys.hdc.section9.task.TaskWithLock;
import com.ys.hdc.section9.task.TaskWithSync;
import com.ys.hdc.section9.thread.TaxCalculator;
import com.ys.hdc.section9.thread.ThreadExtendsThread;
import com.ys.hdc.section9.thread.ThreadImplementsRunnable;
import com.ys.hdc.section9.thread.ThreadWithReturnValue;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author HD
 * @date 2018/9/29 18:02
 */
public class SectionNineCodeTest {

    @Test
    public void demo() {
        ThreadExtendsThread threadOne = new ThreadExtendsThread();
        threadOne.start();
        Thread threadTwo = new Thread(new ThreadImplementsRunnable());
        threadTwo.start();
    }

    /**
     * 建议121：线程池的创建方式
     */
    @Test
    public void demo01() throws ExecutionException, InterruptedException {

        System.out.println("----程序开始运行----");
        Date date1 = new Date();
        int taskSize = 5;
        // 创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        // 创建多个有返回值的任务
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < taskSize; i++) {

            Callable callable = new ThreadWithReturnValue(i + " ");
            // 执行任务并获取Future对象
            Future future = pool.submit(callable);
            System.out.println(">>>" + future.get().toString());
            list.add(future);

        }
        // 关闭线程池   pool.shutdown();
        // 获取所有并发任务的运行结果
        for (Future f : list) {
            // 从Future对象上获取任务的返回值，并输出到控制台
            System.out.println(">>>" + f.get().toString());
        }
        Date date2 = new Date();
        System.out.println("----程序结束运行----，程序运行时间【" + (date2.getTime() - date1.getTime()) + "毫秒】");

        //关闭线程池---通常调用shutdown来关闭线程池，如果任务不一定要执行完，则可以调用shutdownNow
        pool.shutdown();

    }

    /**
     * 线程池两种提交任务的方式
     */
    @Test
    public void demo02() throws ExecutionException, InterruptedException {

        //线程池的创建
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor
                (10, 20, 100L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        //提交任务，无返回值
        threadPoolExecutor.execute(() -> System.out.println("123"));

        //提交任务，有返回值
        Future<Object> future = threadPoolExecutor.submit(new ThreadWithReturnValue("111"));
        System.out.println(future.get());

        //关闭线程池---通常调用shutdown来关闭线程池，如果任务不一定要执行完，则可以调用shutdownNow
        threadPoolExecutor.shutdownNow();
    }
    
    /**
     * 总结：实现Runable或者是继承Thread类，都是没有返回结果，Thread类其实就是实现了Runable，实现Callable有返回结果
     *
     * 建议124：异步运算考虑使用Callable接口
     */
    @Test
    public void demo03() throws InterruptedException, ExecutionException {

        //实现Callable，只是表明他是一个可调用的任务，并不表示它具有多线程的运算能力，还是需要执行器来执行的。这里创建一个单线程执行器
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> future = executorService.submit(new TaxCalculator(100));
        while (!future.isDone()) {
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println("正在计算，请稍等...");
        }
        System.out.println("计算完成，税金是：" + future.get() + "元");

        executorService.shutdown();
    }

    /**
     * 线程创建有五个状态：新建状态(New)、可运行状态(Runable)、阻塞状态(Blocked)、等待状态(Waiting)、结束状态(Terminate)
     *
     * 建议126：实时选择不同的线程池来实现
     *
     * java的线程池共根本上来说只有两个：ThreadPoolExecutor类和ScheduledThreadPoolExecutor类，还是父子关系，
     *
     * 还可以使用一个静态类Executors，他可以直接生成多种不同的线程池执行器。
     */
    @Test
    public void demo04() {

    }

    /**
     * 建议127：Lock与synchronized是不一样的
     */
    @Test
    public void demo05() throws IllegalAccessException, InterruptedException, InstantiationException {

        //看看输出结果、理解一下
        runTasks(TaskWithLock.class);
        runTasks(TaskWithSync.class);

        //====================显示锁Lock是对象级别的锁，内部锁syc是类级别的锁========================

        final Lock lock = new ReentrantLock();

        for (int i = 0; i < 3; i++) {

            new Thread(() -> {
                try {
                    lock.lock();
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }).start();
        }

    }

    public static void runTasks(Class<? extends Runnable> clz) throws IllegalAccessException, InstantiationException, InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("******开始执行" + clz.getSimpleName() + " 任务******");

        for (int i = 0; i < 3; i++) {
            executorService.submit(clz.newInstance());
        }

        TimeUnit.SECONDS.sleep(10);
        System.out.println("------" + clz.getSimpleName() + " 任务执行完毕------\n");

        executorService.shutdown();
    }

}
