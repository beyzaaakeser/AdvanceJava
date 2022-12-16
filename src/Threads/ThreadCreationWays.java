package Threads;

public class ThreadCreationWays {

    public static void main(String[] args) {
        // ilk calisan Thread main thread'dir, kontrol edelim :
        System.out.println("Current Thread : "+Thread.currentThread().getName()); // Current Thread : main

        MyThread thread1 = new MyThread();
        thread1.start(); // Bir threadin calisabilmesi icin start methodu var bunu calistirmamiz lazim.
                         // Thread sinifinda run methodunda yazilanlar islenmeye baslar. MyThread threadi calisiyor dedi

        // thread1.run();

        // run() diyerek cagirdigimizda method yine calisiyor, start() ile cagirmamiz arasindaki fark su :
        // run() ile cagirildiginda thread degismez sadece method calisir.
        // start() da ise once thread ayaga kalkar daha sonra icindeki run() methodu calisir.
        // ??? iki method arasindaki temel fark sudur : start methodu threadi olusturur daha sonra  ????

        MyRunnable runnable = new MyRunnable();
        Thread thread2 = new Thread(runnable);
        thread2.start();

        // !!! isimsiz olarak thread olusturma, annonymous (Interface) 1.YOL
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000); //5 saniye uyu dedik
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Current Thread : "+Thread.currentThread().getName());
                System.out.println("Bu isimsiz sinif yoluyla olusturulan is parcacigidir.");

            }
        });

        thread3.setName("Thread3"); // Thread3'e isim verdim bunda ismini kendimiz istedigimiz sekilde verdik ama burasi olmadan da calisir.
        thread3.start();

        // !!! isimsiz olarak thread olusturalim 2.YOL
        Thread thread4 = new Thread(()->{
            System.out.println("Lambda ile yazildi");
        });
        thread4.start();

        System.out.println("Main Methodu bitti ");
        Thread thread5 = new Thread(() -> {
            System.out.println("thread5 calisti");
        });
        thread5.start();

    }


}

// 1.Yol : Thread classini extends ederek
class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread threadi calisiyor");
    }
}


// 2.Yol : Runnable Interface'i implement ederek
class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Runnable interface'den turetilen thread calisti");
    }
}
