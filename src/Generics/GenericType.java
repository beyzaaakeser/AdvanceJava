package Generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericType <T>{

    /*
        E --> Element, collection gibi yapilarda kullanilir
        K --> Key
        V --> Value
        N --> Number
        T --> Type
        S,U,V, vb --> 2., 3. ve 4. tipler icin

        Not : generic yapilar data turunden bagimsiz yapilar olusturmamizi saglar.
     */



    private T type; // field, variable

    // Getter - Setter
    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    // main method
    public static void main(String[] args) {
        // generic yapi kullanilarak ayni class'dan 2 farkli data turunde obje olusturalim
        GenericType<String> obj1 = new GenericType<>(); // Bunun Field'i String olacak demis oluyoruz o diamond <> arasina String yazinca.
        // Trick : Diamond icine non-primitive type kullanabiliriz. (diamond ici Wrapper class olabilir, primitive olmaz mesela int yazamayiz Integer olacak)
        obj1.setType("Generic Types");

        // GenericType<String> obj2 = new GenericType<>();
        // obj2.setType(65); string girmem gerekirken int data turunu girince CTE verdi

        // Not : Cast Probleminden nasil kurtulurum ?
        GenericType<Integer> obj3 = new GenericType<>();
        obj3.setType(65);
        int a = obj3.getType(); // !!! CAST PROBLEMINDEN KURTULDUK !!!

        // nonGenericType classinda (28.satir) cast yapmak zorunda kalmistik ama burada yapmak zorunda kalmadik kurtulduk

        // NOT : ClassCastException probleminden RunTimeError'dan nasil kurtulurum?
        List<String> list =new ArrayList<>();
        list.add("Alper");
        list.add("Halide");
        // list.add(22); // !!! ClassCastException'dan kurtulduk

        /*
             yani benim eski tarzda(generic olmayan tarzda Object classi kullandigimizda) run time error olarak aldigim hatayi, generic yapida compile time error'a cevirmis olduk.
             nonGenericType classinda 33.satirda compile time error vermiyordu ve biz kod calisiyor sanip devam ediyorduk. calistirinca run time veriyordu.
             Cunku orda cast yaptim saniyorduk. burada generic yapi icine data tipini yazdigimiz icin, run time error ==> compile time error'a dondu ve ClassCastException'dan kurtulduk
        */

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"Generic");
        // map.put("Generic",1);








    }

}
