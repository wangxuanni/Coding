package leetcode.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author keyu
 * @since 2022-03-09 15:58
 **/

public class FooBarCyclicBarrier {

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(10);//打印10次foo bar
        Runnable printFoo = () -> {
            System.out.printf("%s\n", "foo");
        };
        Runnable printBar = () -> {
            System.out.printf("%s\n", "bar");
        };
        Thread fooThread = new Thread(() -> {
            try {
                fooBar.foo(printFoo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread barThread = new Thread(() -> {
            try {
                fooBar.bar(printBar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        fooThread.start();
        barThread.start();

    }

    static class FooBar {
        private int n;

        private CyclicBarrier cb = new CyclicBarrier(2);
        volatile boolean fooExec = true;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (!fooExec) {
                    //false的时候，bar线程在执行，foo线程在这此处空转
                }
                printFoo.run();//打印foo
                fooExec = false;//设置变量
                try {
                    cb.await();//线程foo到达同步点
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                try {
                    cb.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                printBar.run();
                fooExec = true;

            }
        }
    }
}