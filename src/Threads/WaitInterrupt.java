package Threads;

public class WaitInterrupt {

    static public int balance =0;

    public static void main(String[] args) {
        WaitInterrupt obj = new WaitInterrupt();

        // Withdraw threadi ==> Para Cekme threadi
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.withdraw(800);
            }
        });
        thread1.setName("Withdraw Thread");
        thread1.start();

        // Deposit threadi ==> Para Yatirma threadi
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                obj.deposit(2000);
                thread1.interrupt(); // thread2 burada kibarca thread1'i sonlandiriyor
            }
        });
        thread2.setName("Deposit Thread");
        thread2.start();

    }

    public void withdraw(int amount){
        synchronized (this){
            if (balance<=0 || balance <amount){
                System.out.println("Beklemede");
                try {
                    wait();
                } catch (InterruptedException e) {
                   // throw new RuntimeException(e);
                    balance=balance-amount;
                    System.out.println("Basarili");
                }
            } // if blogu sonu
        }
    }

    public void deposit(int amount){
        balance=balance+amount;
        System.out.println("Basarili deposit");
    }

}
