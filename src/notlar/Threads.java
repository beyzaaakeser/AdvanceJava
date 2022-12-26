package notlar;

public class Threads {


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
        - start() methodu thread'i olusturur create eder daha sonra run methoduna gider onu calistirir. Ama su anda kanki canli bir thread vardir ortada
        - run() methodu ise, threadi create etmez. Sanki bir class'in icerisinde bir methodu cagiriyormus gibi on u cagirir sadece. Dolayisiyla o thread havuzuna
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




    /*
    synchronized'de 1 tane thread ile is yapabilirim.
    Ama semaphore'da birden cok thread calisabilir. Mantik benzer ama fark bu.
 */



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


    /*
    synchronized (this) diyincce ayni method icinde bile olsa bu ifadenin yazildigi yer synchronized oluyor.
    (this) ise blogun yazili oldugu methodu cagiran thread ne ise bu this o.
 */


    /*
  Siz bir thread mantigini kullandiginiz bir degiskenin onune volatile keywordunu kullandiginiz an javaya,
  cach'leri hic kullanma devreye sokma direkt ram'in icerisindeki deger uzerinden islem yap diyoruz.
  Ram'in uzerindeki degisken hep sabit olacagi icin thread1 bu variable'ye ulasacgi zaman otomatikman rame gidiyo.
  thread2 de butun threadler de. dolayisiyla butun threadler bu degiskene ulasacagi zaman ayni deger uzerinden islem yapiyorlar.
  Hiz artirmak icin olan CPU icindeki cach'ler karisikliga sebep oluyor volatile bu karisikligi onluyor
  CPU'daki Cach'lerin mantigi : Ram'e gidip gelmek cok kucuk de olsa bir gecikme olusturuyor. Cpu diyor ki Ram'e gitmeyim ben,
  cok kullanilan degiskenleri kendi cach'ime atayim onun uzerinden islem yapayim diyor boyle hiz kazandiriyor.
  Ama burada soyle sonuclar cikiyor, Cach'ler arasindaki ayni degiskenlerin ifadeleri farkli olabiliyor bu da kargasa olusturuyor.
  Kargasa olusmasin diye benim icin hayati onem arz eden degiskenlerin onune volatile keywordu koyuyoruz.
  Kendi cachin uzerinden buna ulasamazsin her halukarda Rame gidip bu degiskenin degerini alacaksin diyoruz.
  Deger birligi saglamis oluyoruz her thread ayni degeri goruyor ve kullaniyor.


  Volatile obje icin de variable icin de kullanilabilir. Degiskenler uzerinde kullaniliyor.
 */

    /*
    notify dedigim anda soyle calisir : wait olan butun threadlere mesaj gider. wait canlanir.
    eger wait koydugumuzda notify demezsek, konsolda kendimiz kareye basip durdurana kadar o thread bekler durur.
    Notify gelene kadar arka planda calisir. kilitlenmez ama o thread bekler (Scanner'da kullanicinin bir sey girmediginde beklemesi gibi)
 */


    // latch ==> Mandal, turnike

/*
    LACH OYLE BIR YAPIDIR KI MAINI BILE DURDURUR.

 */







}
