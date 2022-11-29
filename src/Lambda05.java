import java.util.stream.IntStream;

public class Lambda05 {

    public static void main(String[] args) {

        System.out.println(topla(5));
        System.out.println(topla2(5));
        System.out.println(toplaCift(5));
        System.out.println(toplaIkiPozitifCft(5));
        System.out.println(toplaIkiPozitifTek(5));
        ikininIlkXKuvveti(5);
        System.out.println();
        method1(5,3);
        System.out.println();
        System.out.println(method2(4));

    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar (x dahil) tamsayilari toplayan bir program create ediniz.

    //1.yol structured

    public static int topla(int x){

        int toplam=0;
        for(int i=0;i<=x;i++){
            toplam=toplam+i;
        }
        return toplam;
    }

    //2.yol functional

    public static int topla2(int x){
      return IntStream.     //int  değerlerde akış oluşmasını sağlar. ------>x.stream() gibi bir yapı oluşmasını sağlar
              range(1,x+1). //range(a,b)-->a dan b ye kadar (b dahil değil, int değerler akışa alındı.
              sum();        //akıştan gelen değerler toplandı
    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.

    public static int toplaCift(int x){
        return IntStream.
                rangeClosed(1,x).       //range() den farklı olarak (a,b)---> a ve b yi her ikisini de dahil eder akışa.
                filter(Lambda01::ciftBul).
                sum();
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.

    public static int toplaIkiPozitifCft(int x){

        return IntStream.
                iterate(2,t->t+2).  //2 den sonsuza kadar elemanları 2 artırarak akışa aldık.
                limit(x).
                sum();
    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.

    public static int toplaIkiPozitifTek(int x){
        return IntStream.
                iterate(1,t->t+2).
                limit(x).
                sum();
    }

    //TASK 05 --> 2'nin ilk pozitif x kuvvetini ekrana yazdiran programi  create ediniz.

    public static void ikininIlkXKuvveti(int x){
        IntStream.
                iterate(2,t->t*2).
                limit(x).
                forEach(Lambda01::yazdır);
    }

    //TASK 06 --> Istenilen bir sayinin ilk pozitif x kuvvetini ekrana yazdiran programi  create ediniz.

    public static void method1(int istenenSayi,int x){
        IntStream.
                iterate(istenenSayi,t->t*istenenSayi).
                limit(x).
                forEach(Lambda01::yazdır);
    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.

    public static int method2(int x){
        return IntStream.
                rangeClosed(1,x).               // (1,4)---->1,2,3,4
                reduce(1,(t,u)->t*u);    //

    }







}
