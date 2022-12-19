package Threads;

import java.util.concurrent.CountDownLatch;

// latch ==> Mandal, turnike

/*
    LACH OYLE BIR YAPIDIR KI MAINI BILE DURDURUR.

 */

public class CountDownLatch1 {

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(4); // benim icin oncelikli, once bu 4 threadi calistir demis oluyoruz

        // threadler olusturuluyor
        WorkerThreads worker1 = new WorkerThreads("Worker-1",5000,latch);
        WorkerThreads worker2 = new WorkerThreads("Worker-2",7000,latch);
        WorkerThreads worker3 = new WorkerThreads("Worker-3",9000,latch);
        WorkerThreads worker4 = new WorkerThreads("Worker-4",11000,latch);

        // start()
        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();


        try {
            latch.await(); // countdown 0'a inene kadar bekler. countdowna bakar
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName()+ " has finished");

    }

}



class WorkerThreads extends Thread{
    private int delay; // delay ==> gecikme
    private CountDownLatch latch;

    // constructor
    public WorkerThreads(String name,int delay, CountDownLatch latch) {
        super(name);
        this.delay = delay;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
            System.out.println(Thread.currentThread().getName()+" calisiyor");
            latch.countDown(); // calisan isci sayisina bakar bu sayi 0a dustugu anda diger isciler calismaya baslar
                               // countDown 0'a indiginde bekleyen diger threadler calismaya baslar

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


