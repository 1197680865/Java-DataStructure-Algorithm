package dataStructures.test;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) {
        final CountDownLatch cdA = new CountDownLatch(1);
        final CountDownLatch cdB = new CountDownLatch(1);
        Thread A = new Thread( new Runnable() {
            @Override
            public void run() {
                //doSomeThing
                cdA.countDown();
            }
        },"A");
        Thread B = new Thread( new Runnable() {
            @Override
            public void run() {
                try {
                    cdA.await();
                    //doSomeThing
                    cdB.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B");
        Thread C = new Thread( new Runnable() {
            @Override
            public void run() {
                try {
                    cdB.await();
                    //doSomeThing
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C");
        A.start();
        B.start();
        C.start();
    }
}
