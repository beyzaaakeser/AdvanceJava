package Generics.InterfaceType;

public class GenericClassStringImpl implements GenericInterface<String> {

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

    @Override
    public void setValue(String s) {

    }

    @Override
    public String getValue() {
        return null;
    }
}
