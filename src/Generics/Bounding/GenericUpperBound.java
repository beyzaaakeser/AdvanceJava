package Generics.Bounding;

public class GenericUpperBound<T extends Number> { // Ustten sinirliyorum. Ust sinir Number
    // Parenti number olan butun childlarda ben bu classi kullanabilirim demek bu.



    private T[] numberArray; // field ==> T[] data tipinde array



    // constructor
    public GenericUpperBound(T[] numberArray) {
        this.numberArray = numberArray;
    }

    // array'in icindeki degerlerin ortalamasini bulan method
    public double getAvarage(){
        double sum = 0;

        for (T t: numberArray){
            sum+=t.doubleValue(); // double tipin donduruyor.
        }
        double avg = sum/numberArray.length;

        return avg;
    }


    // main method
    public static void main(String[] args) {
        Integer[] intArray = {2,4,7,33};
        GenericUpperBound<Integer> obj1 = new GenericUpperBound<>(intArray);
        System.out.println("obj1.getAvarage() = " + obj1.getAvarage());

        Double[] doubleArray = {2.5,4.6,7.8};
        GenericUpperBound<Double> obj2 = new GenericUpperBound<>(doubleArray);
        System.out.println("obj2.getAvarage() = " + obj2.getAvarage());

        // !!! ClassCastException almami onluyor
        // String[] strArray = {"Java","Cok","Kolay","Hele","Generics","Tadından","Yenmez"};
        // GenericUpperBound<String> obj2 = new GenericUpperBound(strArray);
    }

        // class generic olur method generic olur ama field generic olmaz data turunu girmek gerekir fieldlarda
















}


