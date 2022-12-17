package Threads;

public class ThreadCreationWays {

    /*
        Thread'ler ayni anda birden fazla isin yapilmasini saglayan yapilardir.
        1 processin parcasidir, is parcacigi da denilebilir.
        Her java programinda en az 1 threads kullanilir o da main thread'dir.

        Youtube'da video izlerken altina yorum yazabilmek gibi. eger threadler olmasaydi yapamazdik boyle.
        ya da goruntulu aramada hem goruntunun hem sesin gitmesi gibi

        Thread nasil olusturulur ?
        1) Thread Class'indan extends ederek
        2) Runnable Interface'inden implement ederek

        ikisinde de run() methodu override ediliyor.Threadler calisirken ne yapmasini istiyorsaniz
        siz Thread class'indan extends de etseniz Runnable classinden implement de etseniz,Bu Thread classi ile Runnable interface'inin icindeki
        run() methodlarini override etmemiz lazim.Aslinda sunu yapmis oluyoruz : Bu classlarim multi thread yapida calisacak ama calisirken bunlari yapsin
        dedigimiz kismi run() methodu icine yaziyorsunuz. Yani bu threadin ne yapmasini istiyorsak run methodunun icine yazicaz.

        Bir Thread'in calisabilmesi icin start() methodu var.
        Bu method : run methodunda yazan seylerin ekrana cikabilmesi icin start methodunu olusturmam gerekiyor.
                    Thread sinifinda run methodunda yazilanlar islenmeye baslar.

        Ben start() yapmadan run() dedigimde de ayni sonucu aliyorum.

        Ama run() methodu ile start() methodu arasindaki temel fark sunlardir:
        - start() methodu thread'i olusturur create eder daha sonra run methoduna gider onu calistirir. Ama su anda kanlki canli bir thread vardir ortada
        - run() methodu ise, threadi create etmez. Sanki bir class'in icerisinde bir methodu cagiriyormus gibi onbu cagirir sadece. Dolayisiyla o thread havuzuna
        girmemistir thread gibi davranmaz. Single bir sey yaziyormussunuz gibi onu calistirir.
        Ben bu methodun canli hale gelip arka planda durmadan bir seyler yapmasini, calistirmasini istiyorsam o zaman ben start() methodunu
        kullanicam ,run degil.


        Thread classindan extends ettigimde sadece olusturuyorum ve start methodunu cagiriyorum.
        Ama Runnable interface'inden implement ettigim classi once bi interface olarak olusturuyorum,
        bu classi da thread classinin parametreli constructor'inin icine arguman olarak gonderiyorum o sekilde thread elde ediyorum.
        Cunku Threadden extends ettigimde bunun donen degeri thread turunde.
        Fakat bu runnable'dan implements ettigimde elimde runnable classi turunde bir class geliyor threads turunde degil,
        interface turunde oldugu icin bunu ben thread turune cevirmem gerekiyor.
        Bir tane Thread classindan instance variable olusturuyorum. Ve THreadin parametreli constructorina da yukarida olusturdugum runnable data turundeki
        runnable ismindeki instance variable'i arguman olarak atiyorum handle ediyorum. Artik Thread thread2 = new Thread(runnable); bunun donen degeri
        thread olmus oluyor ve bu threadi de calistiriyorum artik. Cunku bu start methodu Runnable classina degil Thread classina ait bir method.
        (  MyRunnable runnable = new MyRunnable();
        Thread thread2 = new Thread(runnable);
        thread2.start();   )  aciklamalari

     */

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


        MyRunnable runnable = new MyRunnable();
        Thread thread2 = new Thread(runnable);
        thread2.start();

        // !!! isimsiz olarak thread olusturma, annonymous (Interface) 1.YOL
        Thread thread3 = new Thread(new Runnable() { // burada class olusturuldu ama ismi yok cunku benim bunun ismine ihtiyacim yok
            @Override
            public void run() {
                try {
                    Thread.sleep( 5000); //5 saniye uyu dedik
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Current Thread : "+Thread.currentThread().getName());
                System.out.println("Bu isimsiz sinif yoluyla olusturulan is parcacigidir.");

            }
        });

        thread3.setName("Thread3"); // Thread3'e String bit isim verdim bunda ismini kendimiz istedigimiz sekilde verdik ama burasi olmadan da calisir.
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
class  MyThread extends Thread{
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
