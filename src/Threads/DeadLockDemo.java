package Threads;

// Hangi durumlarda DeadLock olusur ?

public class DeadLockDemo {

    public static void main(String[] args) {


        final String lock1 = "lock1";
        final String lock2 = "lock2";

        // thread1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1) { // thread1 run methodu cagirildigi zxaman lock1'i kitliyor baska kimse kullanamiyor kendi kullaniyor
                    System.out.println("Thread1, lock1 degiskenini kilitledi.");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (lock2){
                        System.out.println("thread1, lock2 degiskenini kilitledi.");
                    } // 2. senkronize blogu sonu

                } // 1. senkronize blogu sonu
            }
        });
        thread1.start();


        // thread2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1) { // thread1 run methodu cagirildigi zxaman lock1'i kitliyor baska kimse kullanamiyor kendi kullaniyor
                    System.out.println("Thread2, lock1 degiskenini kilitledi.");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (lock2){
                        System.out.println("thread2, lock2 degiskenini kilitledi.");
                    } // 2. senkronize blogu sonu

                } // 1. senkronize blogu sonu

            }
        });
        thread2.start();

        // iki thread birbirini bekleyecek ve sonsuza kadar bekleyecek, sonsuz donguye girildi.

    } // main method

} // public class sonu
