package leetcode.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author keyu
 * @since 2022-03-09 12:02
 **/

public class Foo {
    public static void main(String[] args) {
        Foo foo = new Foo();
        Thread thread = new Thread() {
            public void run() {
                System.out.println("first");
            }
        };
        thread.start();

    }

   public class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("second");

        }
    }

    private AtomicInteger first = new AtomicInteger(0);
    private AtomicInteger second = new AtomicInteger(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        System.out.println("111");
        second.decrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (second.get() != 1) {
            System.out.println(second.get());

        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        System.out.println("222");

        first.decrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (first.get() != 1) {

        }
        System.out.println("333");

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
