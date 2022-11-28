import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {
    public static void main(String[] args) {

    List<String> menu = new ArrayList<>(Arrays.asList("trileçe","havucDilim","güvec","kokorec", "küşleme","arabAşı","waffle","künefe","güvec"));

        alfBykTekrsz(menu);

        System.out.println();
        karakterSayısıTersSıraTekrarsız(menu);

        System.out.println();
        karakterSayısınaKücüktenByge(menu);

        System.out.println();
        harfSayisiYediKontrol(menu);

        System.out.println();
        wStartorNot(menu);

        System.out.println();
        xStartWith(menu);

        System.out.println();
        maxKarakterSayisi(menu);

        System.out.println();
        sonHarfeSıralaIlkHaric(menu);


    }

    // Task -1 : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.

    public static void alfBykTekrsz(List<String> yemek){
        yemek.
                stream().                   //akış başladı
                map(String::toUpperCase).   //büyük harf
                sorted().                   //doğal sıralama(burada aalfabetik)
                distinct().                 //elemanların tekrarsız olmasını sağladı
                forEach(t-> System.out.print(t+" "));//yazdırma
    }

    // Task -2 : list elelmanlarinin character sayilarini ters sirali olarak tekrarsiz print ediniz..

    public static void karakterSayısıTersSıraTekrarsız(List<String> ikram){
        ikram.
                stream().
                map(String::length).
                sorted(Comparator.reverseOrder()).
                distinct().
                forEach(Lambda01::yazdır);
    }

    // Task-3 : List elemanlarini character sayisina gore kckten byk e gore print ediniz..

    public static void karakterSayısınaKücüktenByge(List<String> yemek){
        yemek.
                stream().
                sorted(Comparator.comparing(String::length)).//string ifadeleri karakter sayısına göre küçükten büyüğe sıraladık
                forEach(Lambda01::yazdır);
    }

    // ******************************************************************************************
    // *********************** anyMatch() *** allMatch() **** noneMatch() ************************
    //*******************************************************************************************

    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    // Task-4 : List elemalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.

    public static void harfSayisiYediKontrol(List<String> yemek){
        System.out.print(yemek.stream().allMatch(t -> t.length() <= 7) ?
                "list elemanlarının tümü 7 ve daha az harften oluşuyor" :
                "list elemanlarında 7 harften fazla harften oluşanlar mevcut");
    }

    // Task-5 : List elelmanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.

    public static void wStartorNot(List<String>menu){
        System.out.print(menu.
                stream().
                noneMatch(t -> t.startsWith("w")) ?
                "w ile yemek ismi mi olur " :
                "w ile yemek icadettik");
    }

    // Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı var mı kontrol ediniz.

    public static void xStartWith(List<String>menu){
        System.out.print(menu.
                stream().
                anyMatch(t -> t.endsWith("x")) ?
                "En az 1 eleman x ile bitiyor" :
                "x ile biten yok");
    }

    // Task-7 : Karakter sayisi en buyuk elemani yazdiriniz.

    public static void maxKarakterSayisi(List<String>menu){
        Stream<String>sonIsim = menu.
                stream().//akış sağlandı
                sorted(Comparator.comparing(t-> t.toString().length()).
                reversed()).//karakter sayısına göre tersten sıralandı
                limit(1);//1 yazarak ilk eleman çağrıldı
        //limit() methodunun dönen değeri Stream<String> yapıdaır.

        System.out.print(Arrays.toString(sonIsim.toArray()));
    }

    // Task-8 : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.

    public static void sonHarfeSıralaIlkHaric(List<String>menu){

        menu.
                stream().
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))).//son harfe göre alfabetik sıraladı
                skip(1).//akıştaki ilk eleman hariç tutuldu
                forEach(Lambda01::yazdır);

    }








}
