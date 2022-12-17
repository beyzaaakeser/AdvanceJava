package Threads;

public class MultiThreading04 {

    public static void main(String[] args) throws InterruptedException {

        Brackets2 brackets2 = new Brackets2();

        long startTime = System.currentTimeMillis();

        // thread1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1 ; i < 8 ; i++){
                    brackets2.generateBrackets();
                }
            }
        });
        thread1.start();



        // thread2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1 ; i < 8 ; i++){
                    brackets2.generateBrackets();
                }
            }
        });
        thread2.start();
        thread1.join();
        thread2.join();

        long endTime = System.currentTimeMillis();

        // System.out.println("Toplam gecen sure : "+ (endTime-startTime)); //4216
        System.out.println("Toplam gecen sure : "+ (endTime-startTime)); // 2191 oldu blogu synchronized yapinca


    }


}


class Brackets2{
    public  void generateBrackets(){
      synchronized (this){ // this demek : generateBrackets bu methodu cagiran threadin kendisi
          for (int i = 1; i <11 ; i++) {
              if (i<6){
                  System.out.print("[");
              }else{
                  System.out.print("]");
              }
          }// end of for
          System.out.println("");

      } // yani ayni methodda bu blogu senkronize haline getirdik


        // her threadden sonra bir tane sleep methodu gelsin diye
        for (int i = 1; i <6 ; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } // end of for
    }
}