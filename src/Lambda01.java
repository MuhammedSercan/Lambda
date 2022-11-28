import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {

    public static void main(String[] args) {
        /*
      1)  Lambda --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
          Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
      2) "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
          "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
      3)  "Functional Programming" hiz, code kisaligi, code okunabilirligi
          ve hatasiz code yazma acilarindan cok faydalidir.
      4)  Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.


*/

        List<Integer> sayı = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));

        printElStructured(sayı);

        System.out.println();
        printElFunctional(sayı);

        System.out.println();
        printElFunctional1(sayı);

        System.out.println();
        printElFunctional2(sayı);

        System.out.println();
        printCiftElFunctional(sayı);

        System.out.println();
        printCiftElFunctional1(sayı);

        System.out.println();
        printCiftElStructured(sayı);

        System.out.println();
        printCiftOtzdKckFunctional(sayı);

        System.out.println();
        printCiftOtzdBykFunctional(sayı);

    }


    //TASK  : "Structured Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.

    public static void printElStructured(List<Integer> sayı) {
        for (Integer w : sayı) {
            System.out.print(w + " ");
        }
    }

  //TASK  : "functional Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.

    public static void printElFunctional(List<Integer> sayı) {
        sayı.
                stream().
                forEach((t) -> System.out.print(t + " "));// Lambda expression
    }

    public static void printElFunctional1(List<Integer> sayı) {
        sayı.
                stream().
                forEach(System.out::print);// Method Referance
    }

    //--->kendimiz bir method oluşturalım

    public static void yazdır(int a) {
        System.out.print(a + " ");
    }

    public static void yazdır(String a) {
        System.out.print(a + " ");
    }

    public static void printElFunctional2(List<Integer> sayı) {
        sayı.
                stream().
                forEach(Lambda01::yazdır);// Method Referance
    }

    //TASK  : functional Programming ile list elemanlarinin  cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printCiftElFunctional(List<Integer> sayı) {
        sayı.
                stream().
                filter((t) -> t % 2 == 0).
                forEach(Lambda01::yazdır);
    }

        //Yukarıdaki Task i filter() kısmını method referance ile yapalım

        public static boolean ciftBul(int a){
        return a%2==0;
        }

    public static void printCiftElFunctional1(List<Integer> sayı) {
        sayı.
                stream().
                filter(Lambda01::ciftBul).
                forEach(Lambda01::yazdır);
    }




        //TASK  : structured Programming ile list elemanlarinin  cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

        public static void printCiftElStructured (List < Integer > sayı) {
            for (Integer w : sayı) {
                if (w % 2 == 0) {
                    System.out.print(w + " ");
                }
            }

        }

    //TASK :functional Programming ile list elemanlarinin 34 den kucuk cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printCiftOtzdKckFunctional(List < Integer > sayı){

        sayı.
                stream().
                filter(t->t%2==0 && t<34).
                forEach(Lambda01::yazdır);

    }

    //Task : functional Programming ile list elemanlarinin 34 den buyuk eya cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printCiftOtzdBykFunctional(List < Integer > sayı){
        sayı.
                stream().
                filter(t->t%2==0 || t>34).
                forEach(Lambda01::yazdır);

    }











}
