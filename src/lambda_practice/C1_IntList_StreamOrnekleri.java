package lambda_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static lambda_practice.Methods.kupBul;

public class C1_IntList_StreamOrnekleri {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-5,-8,-2,-12,0,1,12,5,6,9,15,8));

        System.out.println("S1 --> ");
        hepsiniYaz(list);
        System.out.println("\nS2 --> ");
        negatifYaz(list);
        System.out.println("\nS3 --> "+pozitifList(list));
        System.out.println("\nS4 --> "+karelerList(list));
        System.out.println("\nS5 --> "+karelerTekrarsizList(list));
        System.out.println("\nS6 --> "+siraliKBList(list));
        System.out.println("\nS7 --> ");
        siraliBKList(list);
        System.out.println("\nS8 --> "+kupBul(list));
        System.out.println("\nS9 --> "+kupBulKare(list));
        System.out.println("\nS10 --> "+toplamList(list));
        System.out.println("\nS11 --> "+negatifKareList(list));
        System.out.println("\nS12 --> "+bestenBuyukSayi(list));
        System.out.println("\nS13 --> "+sıfırdanKucukmu(list));
        System.out.println("\nS14 --> "+yuzeEsitEleman(list));
        System.out.println("\nS15 --> "+sifiraEsitEleman(list));
        System.out.println("\nS16 --> "+ilkBesTopla(list));
        System.out.println("\nS17 --> "+sonBesListele(list));


    }
    // S1:listi aralarinda bosluk birakarak yazdiriniz //
    public static void hepsiniYaz(List<Integer> l){
        l.forEach(t-> System.out.print(t+" "));
    }

    //S2: sadece negatif olanlari yazdir
    public static void negatifYaz(List<Integer> l){
        l.stream().filter(t->t<0).forEach(t-> System.out.print(t+" "));
    }

    //S3: pozitif olanlardan yeni bir liste olustur
    public static List<Integer> pozitifList(List<Integer> l){
       return l.stream().filter(t->t>0).collect(Collectors.toList());
    }

    // S4: list in elemanlarin karelerinden yeni bir list olusturalim
    public static List<Integer> karelerList(List<Integer> l){
        return l.stream().map(t->t*t).collect(Collectors.toList());
    }

    //S5 : list in elemanlarin karelerinden tekrarsiz yeni bir list olusturalim
    public static List<Integer> karelerTekrarsizList(List<Integer> l){
        return l.stream().map(t->t*t).distinct().collect(Collectors.toList());
    }

    //S6: listin elemanlarini kucukten buyuge siralayalim
    public static List<Integer> siraliKBList(List<Integer> l){
        return (List<Integer>) l.stream().sorted().collect(Collectors.toList());
    }

    //S7: listin elemanlarini buyukten kucuge siralayalim
    public static void siraliBKList(List<Integer> l){
        l.stream().sorted(Comparator.reverseOrder()).forEach(t-> System.out.print(t+" "));
    }

    // S8: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
    public static List<Integer> kupBul (List<Integer> l){
        return l.stream().filter(t->t>0).map(t->t*t*t).filter(t->t%10==5).collect(Collectors.toList());
    }

    //S9: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim
    public static List<Integer> kupBulKare (List<Integer> l){
        return l.stream().filter(t->t>0).map(t->t*t).filter(t->t%10!=5).collect(Collectors.toList());
    }

    // S10 :list elemanlarini toplamini bulalim
    public static int toplamList (List<Integer> l){
        return l.stream().reduce(0,(x,y)->x+y);
    }


    // S11 : peek ornegi cozelim - negatiflerin karelerinden list olusturalim
    public static List<Integer> negatifKareList (List<Integer> l){
        return l.stream().filter(t->t<0).peek(t->System.out.println(" Negatif : "+t)).map(t->t*t).peek(t->System.out.println(" Karesi : "+t)).collect(Collectors.toList());
    }

    // S12 : listeden 5 den buyuk  sayi var mi?
    public static List<Integer> bestenBuyukSayi (List<Integer> l){
        return l.stream().filter(t->t>5).collect(Collectors.toList());
        // return l.stream().anyMatch(t->t>5); // boolean
    }

    // S13 : listenin tum elemanlari sifirdan kucuk mu?
    public static boolean sıfırdanKucukmu (List<Integer> l){
        return l.stream().allMatch(t->t<0);
    }

    // S14: listenin 100 e esit elemani yok mu ?
    public static boolean yuzeEsitEleman (List<Integer> l){
        return l.stream().anyMatch(t->t==100);
    }

    // S15: listenin sifira esit elemani yok mu?
    public static boolean sifiraEsitEleman (List<Integer> l){
        return l.stream().anyMatch(t->t==0);
    }

    // S16:  listenin ilk 5 elemanini topla?
    public static int ilkBesTopla (List<Integer> l){
        return l.stream().skip(5).reduce(0,(x,y)->x+y);
    }

    //S17: listenin son bes elemaninin  listele
    public static List<Integer> sonBesListele (List<Integer> l){
        return l.stream().filter(t->t>5).collect(Collectors.toList());
    }

}