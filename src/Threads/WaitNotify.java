package Threads;
/*
    notify dedigim anda soyle calisir : wait olan butun threadlere mesaj gider. wait canlanir.
    eger wait koydugumuzda notify demezsek, konsolda kendimiz kareye basip durdurana kadar o thread bekler durur.
    Notify gelene kadar arka planda calisir. kilitlenmez ama o thread bekler (Scanner'da kullanicinin bir sey girmediginde beklemesi gibi)
 */

public class WaitNotify {

    public static int balance = 0;

    public static void main(String[] args) {
        WaitNotify obj = new WaitNotify();

        // thread1   ==> Para Cekme threadi
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.withdraw(800);
            }
        });
        thread1.setName("Withdraw Thread");
        thread1.start();


        // thread2   ==> Para Yatirma threadi
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000); // eger uyutmazsam iki thread ayni anda calisacak biri parayi atar biri parayi ceker.
                                             // waiti dahi goremeyiz. Bekleme islemi dahi gerceklesmeden islemler hizli sekilde olur biter.
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                obj.deposit(2000);
            }
        });
        thread2.setName("Deposit Thread");
        thread2.start();
    }


    // para cekme methodu
    public void withdraw(int amount){
        synchronized (this){
            if (balance<=0 || balance<amount){
                System.out.println("Balance degeri degisesiye kadar bekliyoruz.");
                try {
                    wait();
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        } // synchronized blog sonu

        try {
                Thread.sleep(5000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        // wait islemi bittikten sonra veya balance degeri zaten yeterli ise
        balance=balance-amount;
        System.out.println("Para cekme isleminiz basariyla gerceklesmistir.");

    }


    // para yatirma methodu
    public void deposit(int amount){
        balance = balance+amount;
        System.out.println("Para yatirma isleminiz basariyla gerceklesmistir");

        synchronized (this){
            notify();
        }
    }








}
