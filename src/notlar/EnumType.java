package notlar;

public class EnumType {


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


    /*
        Eski tarz yapida methoda farkli bir deger verdigimizde hata vermiyor. cikti da vermiyor ama arka tarafta kod calisiyor
        CTE vermedigi icin sorun yok saniyorsun ama var
        Enum yapi ise bunu engelledi. daha kodu yazarken farkli bir deger girildiginde CTE veriyor.
     */











}
