package 剑指Offer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/23 17:52
 */

class Source {
    Lock lock = new ReentrantLock();

    Condition condition = lock.newCondition();

    public static int number = 0;

    public void produce() {
        lock.lock();
        System.out.println("进入生产");
        try {
            while (number != 0) {
                condition.await();
            }
            number++;
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consume() {
        lock.lock();
        System.out.println("进入消费");
        try {
            while (number == 0) {
                condition.await();
            }
            number--;
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class Demo {

    public static void main(String[] args) {
        Source source=new Source();
        new Thread(()->{
            for (int i = 0; i <5 ; i++) {
                source.produce();
                System.out.println(Thread.currentThread().getName()+"\t 数量"+source.number);
            }
        },"AA").start();

        new Thread(()->{
            for (int i = 0; i <5 ; i++) {
                source.consume();
                System.out.println(Thread.currentThread().getName()+"\t 数量"+source.number);
            }
        },"BB").start();

//        new Thread(()->{
//            for (int i = 0; i <5 ; i++) {
//                source.produce();
//                System.out.println(Thread.currentThread().getName()+"\t 数量"+source.number);
//            }
//        },"CC").start();
//
//        new Thread(()->{
//            for (int i = 0; i <5 ; i++) {
//                source.consume();
//                System.out.println(Thread.currentThread().getName()+"\t 数量"+source.number);
//            }
//        },"DD").start();
//
//        new Thread(()->{
//            for (int i = 0; i <5 ; i++) {
//                source.produce();
//                System.out.println(Thread.currentThread().getName()+"\t 数量"+source.number);
//            }
//        },"EE").start();
//
//        new Thread(()->{
//            for (int i = 0; i <5 ; i++) {
//                source.consume();
//                System.out.println(Thread.currentThread().getName()+"\t 数量"+source.number);
//            }
//        },"FF").start();
    }
}
