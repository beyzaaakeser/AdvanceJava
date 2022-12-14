package Generics;

public class NonGenericType {

    private Object o; // Object data turunde o isimle variable olusturdum.

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

        obj1.setO("Mirac"); // String ile set edildi.
        obj2.setO(65); // int ile set edildi.
        // butun wrapper classlar object clasindan turetildigi icin icine koyabiliriz.

        String str1 = (String) obj1.getO(); // !!! CAST PROBLEMI !!!  ==> COMMPILE TIME ERROR
        System.out.println(str1);

        String str2 = (String) obj2.getO(); // !!! RUN TIME ERROR !!! ==> Class Cast Exception
        // String.valueOf( obj2.getO() ); methodunun icerisine ne koyarsak int koyarsak onu Stringe cevirir
        // Integer.parseInt(String);
        // iki methodda tur donusumu yapar.
    }









}
