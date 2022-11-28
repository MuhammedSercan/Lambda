import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda04 {
    /*
    TASK :
    fields --> Universite (String)
               bolum (String)
               ogrcSayisi (int)
               notOrt (int)
               olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
     */
    public static void main(String[] args) {

        Universite u01 = new Universite("Boğaziçi","Matematik",571,93);
        Universite u02 = new Universite("İstanbul T.K.","Matematik",600,81);
        Universite u03 = new Universite("İstanbul","Hukuk",1400,71);
        Universite u04 = new Universite("Marmara","Bilgisayar Müh.",1080,77);
        Universite u05 = new Universite("ODTÜ","Gemi Müh.",333,74);

        List<Universite> unv =new ArrayList<>(Arrays.asList(u01,u02,u03,u04,u05));

        System.out.println("notOrt74BykUnv(unv) = " + notOrt74BykUnv(unv));
        System.out.println("mathVarMı(unv) = " + mathVarMı(unv));
        System.out.println("ogrSayisiBykKckSirala(unv) = " + ogrSayisiBykKckSirala(unv));
    }

    //task 01--> bütün üniv.lerin notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.

    public static boolean notOrt74BykUnv(List<Universite> unv){
        return unv.
                stream().
                allMatch(t->t.getNotOrt()>74);
    }

    //task 02-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.

    public static boolean mathVarMı(List<Universite> unv){
        return unv.
                stream().
                anyMatch(t->t.getBolum().equalsIgnoreCase("Matematik"));
    }

    //task 03-->universite'leri ogr sayilarina gore b->k siralayiniz.

    public static List<Universite> ogrSayisiBykKckSirala(List<Universite> unv){
       return unv.
                stream().//akış sağlandı
                sorted(Comparator.comparing(Universite::getOgrSayisi).//üniversiteler öğrenci sayısına göre tersten sıralandı
                reversed()).collect(Collectors.toList());//stream yapısı list yapısına dönüştürüldü

    }














}
