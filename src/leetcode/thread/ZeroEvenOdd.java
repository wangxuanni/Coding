package leetcode.thread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 打印零与奇偶数
 *
 * @author keyu
 * @since 2022-03-15 23:44
 **/

public class ZeroEvenOdd {
    private int n;
    Semaphore zero = new Semaphore(1);
    Semaphore even = new Semaphore(0);
    Semaphore obb = new Semaphore(0);
    private volatile Integer num = 1;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            zero.acquire();

            printNumber.accept(0);
            if (num % 2 == 0) {
                even.release();
            } else {
                obb.release();
            }

        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            even.acquire();
            printNumber.accept(num++);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            obb.acquire();
            printNumber.accept(num++);
            zero.release();
        }
    }
}
