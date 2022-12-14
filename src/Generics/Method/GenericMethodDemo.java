package Generics.Method;

// Generic Methodlar hangi durumda bize kolaylik saglar ?
public class GenericMethodDemo {

    public static void main(String[] args) {
        GenericMethodDemo obj1 = new GenericMethodDemo();
        Integer[] intArray = {1,23,54,56,45};
        Double[] doubleArray={1.2,2.4,5.6,9.3};

        obj1.print(intArray);
        obj1.print(doubleArray);

    }

    // Kotu ornek. Kod calisir ama kod her update edilmesi gerektiginde yeni method yapman lazim.
    // O yuzden benim buraya oyle bir kod yazmam lazim ki data turunden bagimsiz bir method (generic method) olusturmam lazim
//    public void print(Integer[] arr){
//        // *******
//    }
//    public void print(Double[] arr1){
//
//    }


    // generic method
    public <T> void print(T[] array){
        for (T t: array){
            System.out.println(t);
        }
    }



}
