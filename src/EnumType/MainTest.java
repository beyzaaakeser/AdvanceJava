package EnumType;

public class MainTest {

    public static void main(String[] args) {

     /*
        Eski tarz yapida methoda farkli bir deger verdigimizde hata vermiyor. cikti da vermiyor ama arka tarafta kod calisiyor
        CTE vermedigi cin sorun yok saniyorsun ama var
        Enum yapi ise bunu engelledi. daha kodu yazarken farkli bir deger girildiginde CTE veriyor.
     */


        useConstantMethod(1);
        useConstantMethod(2);
        useConstantMethod(3);
        useConstantMethod(4);
        useConstantMethod(100);
        useConstantMethod(5); // cte vermedi. ama cikti da vermedi. arka tarafta calisiyor
        // iste enum yapi bize bunu sagliyor veremezsin diyor enumda farkli bir deger girince cte oluyor

        System.out.println("------------------------");

        useEnumMethod(TransactionType.DEPOSIT);
        useEnumMethod(TransactionType.PAYMENT);
        useEnumMethod(TransactionType.WITHDRAW);
        useEnumMethod(TransactionType.OTHER);
        // useEnumMethod(TransactionType.A);  CTE enum yapida bana baska bir deger girmeme izin vermedi

    }

    // eski tarz
    private static void useConstantMethod(int i){
        if (i==TransactionTypeConstant.DEPOSIT){
            System.out.println("Money is depositing");
        }else if (i == TransactionTypeConstant.WITHDRAW){
            System.out.println("Money is withdrawing");
        }else if (i == TransactionTypeConstant.TRANSFER){
            System.out.println("Money is transfering");
        }else if (i == TransactionTypeConstant.PAYMENT){
            System.out.println("Money is being made");
        }else if (i == TransactionTypeConstant.OTHER){
            System.out.println("Other transaction");
        }
    }



    // enum yapi ile
    private static void useEnumMethod(TransactionType transactionType){
            if (transactionType == TransactionType.DEPOSIT){
                System.out.println("Money is depositing");
            } else if (transactionType == TransactionType.PAYMENT) {
                System.out.println("Money is being made");
            } else if (transactionType == TransactionType.WITHDRAW) {
                System.out.println("Money is withdrawing");
            }else if (transactionType == TransactionType.TRANSFER) {
                System.out.println("Money is transfering");
            }else if (transactionType == TransactionType.OTHER) {
                System.out.println("Other transaction");
            }


            // Not : Enum yapiya has methodlar
            System.out.println("Enum Name : "+ transactionType.name()); // Enum ismini ekranayazdim
            System.out.println("Enum Coder Value : "+ transactionType.getTransactionCode()); // Enum'in numeric degerini aldim. islem sayisi kacsa onu verecek.
            System.out.println("Enum Ordinal : "+ transactionType.ordinal()); // Enum'in sirasi kacsa onu alir

    }


}
