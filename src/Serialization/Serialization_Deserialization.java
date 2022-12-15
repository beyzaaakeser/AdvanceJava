package Serialization;

import java.io.*;

public class Serialization_Deserialization {

    public static void main(String[] args) {
        // writeObject(); 'de serilization yapiyoruz
         readObject(); // de deserilization yapmis olduk
    }

    // writeObject()
    private static void writeObject(){
        System.out.println("User Objeleri olusturuluyor...");
        User user1 = new User(1L,"Yunus","123456789");
        User user2 = new User(2L,"Yusuf","289876843");
        User user3 = new User(3L,"Betul","323456571");

        try(FileOutputStream fos = new FileOutputStream("user.dat")){ // bu satir dosya yazmak icin.
            try(ObjectOutputStream oos = new ObjectOutputStream(fos)){ // bu try kismi ise Objeleri yazmak icin.
               oos.writeObject(user1);
               oos.writeObject(user2);
               oos.writeObject(user3);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // readObject()
    private static void readObject(){
        // Javada File islemlerinde okuma islemi yaparken FileInputStream classi kullanilir.
        try(FileInputStream fis = new FileInputStream("user.dat")){ // okunacak dosyayi belirledik.
            try(ObjectInputStream ois = new ObjectInputStream(fis)){ // obje olarak okunacak
                User user1 = (User) ois.readObject();
                User user2 = (User) ois.readObject();
                User user3 = (User) ois.readObject();

                System.out.println(user1);
                System.out.println(user2);
                System.out.println(user3);
            }catch (ClassNotFoundException e){
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

// User classini transfer edilebilsin diye isaretledik, Serializable interface'ine implement ederek.
class User implements Serializable {

    // private fieldlar
    private Long id;
    private String name;
    private String tcKimlikNo;

    // constructor
    public User(Long id, String name, String tcKimlikNo) {
        this.id = id;
        this.name = name;
        this.tcKimlikNo = tcKimlikNo;
    }

    // getter - setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTcKimlikNo() {
        return tcKimlikNo;
    }

    public void setTcKimlikNo(String tcKimlikNo) {
        this.tcKimlikNo = tcKimlikNo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tcKimlikNo='" + tcKimlikNo + '\'' +
                '}';
    }

    // to string yazdirmazsak fieldlarin adreslerini verir. to string kullanirsak fieldlar gelir okuyabiliriz.


}