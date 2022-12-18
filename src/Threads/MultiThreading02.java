package Threads;

/*
    Threadler ayni kaynaga erismek isterlerse ne olacak ?
    Bir variable olusturduk. Static yaptik ki . koyup ulasabilelim.
    Birden fazla thread ile o variable'i degistirmek istesem ne elde ederim
    Multithread mantiginda yapisinda herkes kafasina gore bu kaynaga ulasmasin diye bu problemi cozmeye calisacagiz.
    Variable'in static olmasi butun objeler icin son degeri neyse onu gosterecek demek. Gokteki ay gibi



    synchronized : demek Methoda oyle bir sey ekleyim ki, bu methodun icerisinde bir tane thread varken baska bir thread girmesin.
    once ilk threadin cikmasini beklesin.
    Joinle' de ayni islemi yapiyorum ama bu durum her zaman dinamik olmayabilir.
    synchronized ise dinamik olmasini sagliyor.
    synchronized ile bu methoda giren threadleri siraya koymus olduk
    method icine ayni anda sadece 1 thread girebilecek.

    Join methodunu ve synchronized'i rastgele kullanmamamiz lazim. Cunku bunlar sureyi uzatir ve bu durum thread mantigina
    aykiri olur. Bu methodlar bir thread bitmeden digerini alma calistirma demek gibi oldugu icin sureyi uzatiyor.
    rastgele kullanildiginda ayni anda calisip isi bitirmeye el verisli olmuyor thread mantigina aykiri oluyor.


 */
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
        thread1.start(); // bu thread calistigi anda icindeki run methoduna; count methodu kondugu icin,
                        // count methodu counteri 1000 yapcak ve static oldugu icin counter artik 1000 olacak
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
        thread2.start(); // bu thread calistigi anda icindeki run methoduna count methodu kondugu icin;
        // count methodu, counteri 1000den 2000 yapcak ve static oldugu icin counter artik 2000 olacak
        // counter variable'i static ve thread1 calistigi anda counter 1000 oldugu icin thread2 calisinca 1000den 2000 yapacak

    } // main method


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