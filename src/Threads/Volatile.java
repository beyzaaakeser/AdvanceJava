package Threads;

public class Volatile {

    volatile static int flag = 0;

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (flag == 0) {
                        System.out.println("Thread1 calisiyor");
                    } else {
                        break;
                    }
                }
            }
        });
        thread1.start();

        // thread2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                flag=1;
                System.out.println("Flag degeri 1 olarak degistirildi ");
            }
        });
        thread2.start();

    }
}
