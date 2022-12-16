package Generics.Bounding;

import java.util.ArrayList;
import java.util.List;

public class GenericLowerBoundAndWildCard {

    public static void main(String[] args) {

        // *********** addElements **********
        List<Object> ol = new ArrayList<>();
        addElements(ol);

        List<Number> nl = new ArrayList<>();
        addElements(nl);

        List<Double> dl = new ArrayList<>();
        // addElements(dl); // CTE ,
                        // Generic oncesi yapilarda run time error olurdu. ama generic ile cte'ye cevrildi bize sagladigi yarar bu.

        // *********** printElements **********
//        List<String> st = new ArrayList<>();   1
//        printElements(st);

        printElements(new ArrayList<String>());  // 2
        // bu ikisi de ayni islemi yapar


        // *********** printObj **********
        List<String> strList = new ArrayList<>();
        // printObj(strList); // CTE

        List<Object> objectList = new ArrayList<>();
        printObj(objectList);


    }  // main



    public static void addElements(List<?super Integer> list){ // alttan sinirliyorum
        // ? : WildCard ( tipi bilinmeyen )
        // super Integer : bana Integer'in parent'larini getir demek oluyor. Alt siniri belirliyoruz alt sinir Integer

        for (int i = 1; i<=10 ; i++){
            list.add(i);
        }
    }

    // WildCard  sinirlamalari
    public static void printElements(List<?> listOfUnknown){
        // listOfUnknown.add("Java"); --> ? dan dolayi data turu netlesmeden add methodu gibi islemleri yaptirmaz
        // add methodu gibi islem yaptirmaz
        // listOfUnknown.add(null); // illa bir sey eklenecekse null eklenebilir.

        for (Object object: listOfUnknown){
            System.out.println(object);
        }

    }

    // ? yerine Object yazsaydik ne olurdu ?
    public static void printObj(List<Object> listOfObject){

        listOfObject.add("Java");

        for (Object object: listOfObject){
            System.out.println(object);
        }
    }

} // class
