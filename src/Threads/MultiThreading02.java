package Threads;

public class MultiThreading02 {

    public static int counter = 0;
    public static void main(String[] args) {

        // !!! Ayri 2 thread olusturup ayni kaynaga erismesini saglayalim
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Counter.count();
                System.out.println("Thread1 calisti ");
            }
        });
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // 2.thread olusturuyoruz
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Counter.count();
                System.out.println("Thread2 calisti ");
            }
        });
        thread2.start();

    }


}

class Counter{
    public synchronized static void count(){  // synchronized ile bu methoda giren threadleri siraya koymus olduk
        // method icine ayni anda sadece 1 thread girebilecek
        for (int i = 1; i <1001 ; i++) {
            MultiThreading02.counter++; // son alacagi dseger 1000
        }
        System.out.println("Counter : "+MultiThreading02.counter);
    }

}