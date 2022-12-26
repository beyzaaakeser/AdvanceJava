package notlar;

public class Generics {

     /*
                                        INTERVIEW SORUSU
              Neden bir integer data turunu Stringe cast islemi ile cozumleyemiyorum ?
              Iki class'i birbirine cast edebilmem icin ayni hiyerarside olmasi lazim. Yani birbirinden turemesi lazim.
              Integer, Stringden mi turemis? Hayir. String, Integer'dan mi turemis? Hayir.
              O zaman ben bunlari birbirine Cast yapamam.

              Ornek : Mesela bir A classimiz var. Object Class'indan turettik. Bir B class'imiz var. B'yi de A'dan turettik.
                      Iste ben burada cast yapabilirim. B'yi, A'ya cast edebilirim.A'yi ad Object'e cast edebilirim, problem yok.
                      Cunku ayni hiyerarsideler. Parent-Child iliskisi var.

              Eger ben Cast islemini kullanacaksam,Parent-Child iliskisi olan farkli classlari cast yapabilirim.

              Peki ben hicbir zaman mi Integer bir degeri Stringe ceviremeyecegim?
              Bunu 2 yol ile yapabiliriz.
              1) valueOf() methodu ile.
              2) parseInt() methodu ile

              iki methodda tur donusumu yapar.


         */


       /*
        E --> Element, collection gibi yapilarda kullanilir
        K --> Key
        V --> Value
        N --> Number
        T --> Type
        S,U,V, vb --> 2., 3. ve 4. tipler icin

        Not : generic yapilar data turunden bagimsiz yapilar olusturmamizi saglar.
     */



    /*

Generic yapıda bir Interface kullanarak bir Class oluşturmak istediğimde
1) Ya hem class hem interface generic olmak zorunda
2) Ya da class klasik yapıda kalacak ve Interface generic olmayacak (T, E gibi bir ifade yerine String,Integer gibi daha kesin bir değer alacak)

*/


    // bu classi generic yapmak istemiyorum ama generic'ten turetmek istiyorum hedef bu.
    // eger ben generic olmayan bir class turetmek istiyorsam burada <> artik data turunu belirtmem gerekiyor.


    /*
         OZET NOT :
         Ben generic yapida bir interface'i kullanarak classlar ureteceksem implement edeceksem 2 seye dikkat edicem
         1) Eger bu generic interface'in icindeki <T> variable dedigimiz kisim hala generic olarak kalacaksa o zaman
            implement edecegim classi da generic yapida olusturmam gerekiyor. Cunku  turu belli degil dolayisiyla olusacak classin da turu(Data tipi) belli degil.

         2) Eger class'im generic yapida olmasin istiyorsam o zaman implement ettigim interface'in diamond operatorunun icine <> hangi data turunu
            istiyorsam onu yaziyorum. Stringse String bu classdaki ornek gibi. Integersa Integer vb...
     */


    // class generic olur method generic olur ama field generic olmaz data turunu girmek gerekir fieldlarda







}
