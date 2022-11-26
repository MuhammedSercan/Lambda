import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {

    public static void main(String[] args) {

        List<Integer> sayı = new ArrayList<>(Arrays.asList(4, 2, 6, 11,-5, 7, 3, 15));

        ciftKarePrint(sayı);

        System.out.println();
        ciftKarakök(sayı);

        System.out.println();
        tekKüpBirFazlasıPrint(sayı);

        System.out.println();
        enBuyuk(sayı);


        System.out.println();
        ciftKareEnBuyk(sayı);

        System.out.println();
        toplamTumu(sayı);

        System.out.println();
        carpımÇift(sayı);
        System.out.println();
        carpımÇift1(sayı);

        System.out.println();
        enKucukBul(sayı);

        System.out.println();
        bestenBuyukEnKucukTek(sayı);

        System.out.println();
        gunSonuMethodu(sayı);


    // Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini ayni satirda aralarina bosluk bırakarak print ediniz
    }


        public static void ciftKarePrint(List<Integer> sayı){
        sayı.
                stream().
                filter(Lambda01::ciftBul).   // Akıştaki çift sayıları filtreledim
                map(t->t*t).                 // 16,4,36 --- Streamdaki elemanları başka değerlere dönüştürüyor.(karesi almak gibi)
                forEach(Lambda01::yazdır);
        }

    // Task-2: Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print edi

    public static void tekKüpBirFazlasıPrint(List<Integer> sayı){
        sayı.
                stream().
                filter(t->t%2!=0).
                map(t->(t*t*t)+1).
                forEach(Lambda01::yazdır);
    }

    // Task-3 : Functional Programming ile listin cift elemanlarinin karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void ciftKarakök(List<Integer> sayı){
        sayı.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt).  //double
                forEach(t-> System.out.print(t+" "));
    }

    // Task-4 : list'in en buyuk elemanini yazdiriniz

    public static void enBuyuk(List<Integer> sayı){
        Optional<Integer> maxSayı = sayı.
                stream().
                reduce(Math::max); // eğer result tek bir değer ise;reduce()terminal operatorü kullanılır.
        System.out.print(maxSayı);
    }

    // Structured yapı ile çözelim
    public static void structuredMAxElBul(List<Integer> sayi){
        int max = Integer.MIN_VALUE;
        System.out.println("max = " + max); // max.soutv
        for(int i=0; i<sayi.size();i++) {
            if(sayi.get(i)>max) max = sayi.get(i);
        }
        System.out.print("en büyük sayı : " + max);

    }


    // Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz

    public static void ciftKareEnBuyk(List<Integer> sayi){
        System.out.print(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t->t*t).
                reduce(Integer::max)); //Math::max a göre daha hızlı çalışır

    }

    // Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...

    public static void toplamTumu(List<Integer> sayi){
        int toplam = sayi.
                stream().
                reduce(0,(a,b)->a+b);
        System.out.print("toplam = " + toplam);
        /*
        * a ilk degerini her zaman atanan degerden (ilk parametre) alır,
        bu örnekte 0 oluyor
        * b degerini her zamana  stream()'dan akısdan alır
        * a ilk degerinden sonraki her değeri action(işlem)'dan alır
        */
    }

    // Task-7 : List'teki cift elemanlarin carpimini  yazdiriniz.

    public static void carpımÇift(List<Integer> sayi){
        System.out.print(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(Math::multiplyExact));//method referance
    }

    public static void carpımÇift1(List<Integer> sayi){
        System.out.print(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(1,(a,b)->(a*b)));//lambda expression
    }

    // Task-8 : List'teki elemanlardan en kucugunu  print ediniz.

        //1.yol-method referance
    public static void enKucukBul(List<Integer> sayi){
        System.out.println(sayi.
                stream().
                reduce(Integer::min));

        //2.yol-method referance
        System.out.print(sayi.
                stream().
                reduce(Lambda02::byMiracMin));
    }

    public static int byMiracMin(int a,int b){

        return a<b ? a :b ;
    }

    // Task-9 : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.

    public static void bestenBuyukEnKucukTek(List<Integer> sayi){
        System.out.print(sayi.stream().
                filter(a -> a > 5 && a % 2 != 0).
                reduce(Lambda02::byMiracMin));
    }

    // Task-10 : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.

    public static void gunSonuMethodu(List<Integer> sayi){

        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t->t*t).
                sorted().
                forEach(Lambda01::yazdır);
    }



}
