package Generics;

public class NonGenericType {

    private Object o; // Object data turunde o isimle variable(field) olusturdum.

    // Getter - Setter
    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }


    public static void main(String[] args) {
        NonGenericType obj1 = new NonGenericType();
        NonGenericType obj2 = new NonGenericType();

        obj1.setO("Mirac"); // String ile set edildi. Data turu object oldugu icin her seyi atabilirim ben bunun icine.
                            // O yuzden String atabildim ve set ettim Butun Stringler objecttir zaten
        obj2.setO(65);      // int ile set edildi.Data turu object oldugu icin her seyi atabilirim ben bunun icine.
                            // O yuzden in atabildim ve set ettim.Butun intler objecttir zaten
                            // butun wrapper classlar object clasindan turetildigi icin icine koyabiliriz.

        String str1 = (String) obj1.getO(); // !!! CAST PROBLEMI !!!  ==> COMMPILE TIME ERROR
        // Sadece getO dedigimizde kiziyor. Basina (String) diye cast islemi istiyor. Iste cast problemi budur.
        System.out.println(str1);



        String str2 = (String) obj2.getO(); // !!! RUN TIME ERROR !!! ==> Class Cast Exception
        // String.valueOf( obj2.getO() ); methodunun icerisine ne koyarsak int koyarsak onu Stringe cevirir
        // Integer.parseInt(String);
        // iki methodda tur donusumu yapar.


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
    }









}
