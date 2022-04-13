package leetcode.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author keyu
 * @since 2022-03-09 15:58
 **/

public class FooBarBlockingQueue {private int n;
    BlockingQueue<Integer> foo = new ArrayBlockingQueue<Integer>(1);
    BlockingQueue<Integer> bar = new ArrayBlockingQueue<Integer>(1);

    public FooBarBlockingQueue(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        foo.add(1);
        for (int i = 0; i < n; i++) {
            foo.take();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            bar.add(1);
        }

    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            bar.take();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foo.add(1);
        }
    }
}
