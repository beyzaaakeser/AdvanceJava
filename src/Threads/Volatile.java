package Threads;

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
 */



public class Volatile {

    volatile static int flag = 0; // variable, degisken

    public static void main(String[] args) {


        // thread 1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (flag == 0) { // Sonsuz dongu yaptik bilerek...
                        int i = 1;
                        System.out.println("Thread1 calisiyor");
                    } else {
                        break;
                    }
                }
            }
        });
        thread1.start();


        // thread 2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);  // Sonsuz donguyu kirmak icin yazdik...
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag =1;
                System.out.println("Flag degeri 1 olarak degistirildi..");
            }
        });
        thread2.start();
    }



















}
