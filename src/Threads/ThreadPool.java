package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2); // bu satir threadpoolu olusturuyor,
                                                                           // thread havuzunun icinde kac tane thread olacagini soyledik.

        // instance variable olarak 10 adet thread olusturuldu
        ThreadCreator thread1 = new ThreadCreator("Thread1 ");
        ThreadCreator thread2 = new ThreadCreator("Thread2 ");
        ThreadCreator thread3 = new ThreadCreator("Thread3 ");
        ThreadCreator thread4 = new ThreadCreator("Thread4 ");
        ThreadCreator thread5 = new ThreadCreator("Thread5 ");
        ThreadCreator thread6 = new ThreadCreator("Thread6 ");
        ThreadCreator thread7 = new ThreadCreator("Thread7 ");
        ThreadCreator thread8 = new ThreadCreator("Thread8 ");
        ThreadCreator thread9 = new ThreadCreator("Thread9 ");
        ThreadCreator thread10 = new ThreadCreator("Thread10");

        service.execute(thread1);
        service.execute(thread2);
        service.execute(thread3);
        service.execute(thread4);
        service.execute(thread5);
        service.execute(thread6);
        service.execute(thread7);
        service.execute(thread8);
        service.execute(thread9);
        service.execute(thread10); // burada sunu yapmis oluyorum, bu threadlerin 2 tanesini alacak ya,
                                    // bittigi zaman yeniden thread olusmayacak icerideki thread digerlerinin isini yapacak

        service.shutdown(); // thread havuzundaki threadler beklemeye devam eder.


    }
}
    class ThreadCreator extends Thread {

        private String threadName;

        // constructor
        public ThreadCreator(String threadName) {
            this.threadName = threadName;
        }

        @Override
        public void run() {
            System.out.println(threadName + " thread started");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(threadName + " Thread stopped");
        }
    }

