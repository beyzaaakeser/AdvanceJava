package EnumType;

public enum TransactionType {

    DEPOSIT(5),
    WITHDRAW(10),
    TRANSFER(15),
    PAYMENT(20),
    OTHER(100);

    private final int transactionCode; // final'i iki turlu setleyebiliriz. enum yapisinda constructorlar ile setleriz.

    // getter
    public int getTransactionCode() {
        return transactionCode;
    }

    /*
       transactionCode'un getter'i. Bu withdraw, deposit gibi islemlerin hangi kodla calistrigini gormemiz icin yapildi.
       biz burada mesela Deposit islemini calistirabilmek icin 5 kodunu girmemiz gerekiyor gibi dusun.
       Bu sayilari uygulamanizin isleyisine gore verebilirsiniz takilmayin dedi.
     */

    // constructor
    private TransactionType(int code){
        this.transactionCode= code;
    }

    /*
        TransactionCode variable'ini DEPOSIT WITHDRAW gibi islemleri string ifadelerle degil de int ifadelerle ulasmak icin yapti.
        Daha sonra transactionCode'un parametreli constructorunu olusturdu.
        Yani transactionCode variable'inin degerini constructordan aldi

        Enum yapiilardaki sayisal degerleri set etmek istiyorsam bu ikisini yapmam lazim variable + constructor
     */


}
