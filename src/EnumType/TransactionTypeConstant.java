package EnumType;

public class TransactionTypeConstant { // degistirelemez sabit variable demek constant variable

    public static final int DEPOSIT =1; // TransactionTypeConstant.DEPOSIT
    public static final int WITHDRAW =2;
    public static final int TRANSFER =3;
    public static final int PAYMENT =4;
    public static final int OTHER =100;


    /*
        Enum oncesinde Constant variable olusturmam gerekiyor.
        final ve static olmasi gerekiyor
        Herhangi bir field'i static olarak olusturursaniz su anlama geliyor :
        o fielda ulasmak icin o field'in ait oldugu class'i uretmemize gerek yok.
        Nokta diyip ulasabiliriz.TransactionTypeConstant.DEPOSIT gibi.
        Eger static olmasaydi TransactionTypeConstant'dan bir instance variable olusturacaktim bunun uzerinden DEPOSIT'e gidecektim.

        Final yapmak ise sunu sagliyor :
        O field'a bir deger set ettigimiz zaman bir daha degistirilemiyor.


        Bu Classin butun fieldlarini static ve final yaparak aslinda sunu yapmis oldum
        Classtan bagimsiz bu fieldlara ulasabilecegim ve degerlerini bir daha degistiremeyecegim.
     */


}
