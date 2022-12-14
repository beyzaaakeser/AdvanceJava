package Generics.InterfaceType;

// 1) eger bir generic interface implement ederseniz, class da generic olmali
// 2) Core javadan gelen kisim interface classlarin icindeki methodlari override etmelisin implement etmelisin kullanabilmek icin
public class GenericClassImpl<T> implements  GenericInterface<T>{

    @Override
    public void setValue(T t) {

    }

    @Override
    public T getValue() {
        return null;
    }
}

/*

Generic yapıda bir Interface kullanarak bir Class oluşturmak istediğimde
1) Ya hem class hem interface generic olmak zorunda
2) Ya da class klasik yapıda kalacak ve Interface generic olmayacak (T, E gibi bir ifade yerine String,Integer gibi daha kesin bir değer alacak)

*/