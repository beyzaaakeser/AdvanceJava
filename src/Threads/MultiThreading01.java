package Threads;

public class MultiThreading01 {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        CounterWithoutMultiThread counter1 = new CounterWithoutMultiThread(1);
        CounterWithoutMultiThread counter2 = new CounterWithoutMultiThread(2);
        counter1.countMe();
        System.out.println("--------------------------");
        counter2.countMe();
        long endTime = System.currentTimeMillis();
        System.out.println("WithoutMultiThread ile gecen sure : "+ (endTime-startTime));

        System.out.println("**************************");

        long startTime2 = System.currentTimeMillis();
        CounterWithMultiThread counter3 = new CounterWithMultiThread(1);
        CounterWithMultiThread counter4 = new CounterWithMultiThread(2);
        counter3.start();
        System.out.println("--------------------------");
        counter4.start();
        counter3.join(); // counter3 threadi bitesiye kadar bekle
        counter4.join(); // counter4 threadi bitesiye kadar bekle
        // join methodu bu thread bitmeden alt satira gecme diyor. bir nevi orada single thread varmis gibi davraniyor.
        long endTime2 = System.currentTimeMillis(); // bu end time hesaplanmadan once joinleri belirlememiz lazim.
        System.out.println("WithMultiThread ile gecen sure : "+ (endTime2-startTime2));

    }




}

class CounterWithoutMultiThread {

    // field
    private int threadNum;

    // constructor
    public CounterWithoutMultiThread(int threadNum) {
        this.threadNum = threadNum;
    }


    // method
    public void countMe() throws InterruptedException {
        for (int i = 1; i<=10; i++){
            Thread.sleep(500); // burada main thread'i 0.5 saniye yavaslatir.
            // normal bir class icerisindeyim bir thread'de degilim. ve bu class icinde yavaslat diyorsam
            // yavaslatacagi tek thread var ==> main thread
            System.out.println("i= "+i+" Thread number : "+ threadNum);
        }
    }
}


class CounterWithMultiThread extends Thread{

    // field
    private int threadNum;

    // constructor
    public CounterWithMultiThread(int threadNum){
        this.threadNum=threadNum;
    }


    // run methodunu override ettik
    @Override
    public void run() {
        try {
            countMe();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // method
    public void countMe() throws InterruptedException {
        for (int i = 1; i<=10; i++){
            Thread.sleep(500); // bu main thread'i 0.5 saniye yavaslatir.
            System.out.println("i= "+i+" Thread number : "+ threadNum);
        }
    }
}

