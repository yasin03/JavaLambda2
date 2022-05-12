package lambda_practice;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class C6_Lambdada_ForLoop_Aralik_Kontrolu {

    public static void main(String[] args) {


        // S1:1 den 30 kadar olan sayilari (30 dahil degil) 1 2 3 .... seklinde siralayalim (for loopsuz)
        //range(int startInclusive, int endExclusive)
        IntStream.range(1, 30).forEach(t -> System.out.print(t + " "));

        //S2 1 den 30 kadar olan sayilari (30 dahil ) 1 2 3 .... seklinde siralayalim (for loopsuz)
        //rangeClosed(int startInclusive, int endInclusive)
        System.out.println();
        IntStream.rangeClosed(1, 30).forEach(t -> System.out.print(t + " "));

        //S3 Istenen iki deger(dahi) arasindaki sayilari toplayalim
        istenenToplam(5,12);

        //S4: 30 ile 40 arasindaki sayilarin (dahi) ortalamasini bulalim
        istenenOrtalama(30,40);

        //S5: 325 ile 468 arasinda 8 e bolunen kac sayi vardir?
        sekizeBolunenSay(325,468);

        //S6: 325 ile 468 arasinda 8 bolunen sayilari yazdiralim
        sekizeBolunenYaz(325,468);


        // S7:325 ile 468 arasinda 8 bolunen sayilarin toplamini bulalim
        sekizeBolunenToplam(325,468);


        // S8: 7 ile 15 arasindaki tek sayilarin carpimini bulalim
        System.out.println("\nTek Sayıların Çarpımı -> "+IntStream.rangeClosed(7, 15).filter(Methods::tekMi).reduce((t, u) -> t * u).getAsInt());

        //S9: pozitif tek sayilarin ilk 10 elemanin yazdiralim
        System.out.println("\nİlk 10 Pozitif Tek Sayılar -> ");
        pozitifTek();

        //S10: 21 den baslayan 7 nin katlarinin tek olanlari ilk 10 teriminin yaziralim
        System.out.println("\n21den Başlayan 7 Katı Tek Sayılar -> ");
        IntStream.iterate(21,t->t+7).filter(Methods::tekMi).limit(10).forEach(Methods ::yazInteger);

        //S11: 21 den baslayan 7 nin katlarinin ilk 20 teriminin toplayalim
        System.out.println("\n21den Başlayan 7 Katı Toplamı Sayılar -> ");
        System.out.println(IntStream.iterate(21, t -> t + 7).limit(20).sum());
    }

    private static void pozitifTek() {
        IntStream.iterate(1,t->t+2).limit(10).forEach(Methods::yazInteger);
        // IntStream.rangeClosed(1,a).limit(10).filter(Methods::tekMi).forEach(Methods ::yazInteger);
    }

    private static void sekizeBolunenToplam(int i, int i1) {
        System.out.println("\nSekize Bölünen Topla -> "+IntStream.rangeClosed(i, i1).filter(t -> t % 8 == 0).sum());
    }

    private static void sekizeBolunenYaz(int i, int i1) {
        System.out.print("Sekize Bölünen Yaz -> ");
        IntStream.rangeClosed(i, i1).filter(t -> t % 8 == 0).forEach(t -> System.out.print(t+" "));
    }

    private static void sekizeBolunenSay(int i, int i1) {
        System.out.println();
        System.out.println("Sekize Bölünen Say -> " +IntStream.rangeClosed(i, i1).filter(t -> t % 8 == 0).count());
    }

    private static void istenenOrtalama(int a, int b) {
        System.out.println();
        System.out.println("Ortalama -> "+IntStream.range(a, b).average().getAsDouble());
    }

    private static void istenenToplam(int a, int b) {
        System.out.println();
        System.out.println("Toplam -> "+IntStream.range(a, b).reduce(Integer::sum).getAsInt());
    }


}
//iterate bize sayilari istedigimiz sekilde yineletmeyi saglar yani buradaki ornekte 7ser7ser artmayi saglar
//iterate icin bir baslangic degeri girilmeli ve artisin nasil olacagi belirtilmeli nerede biteceginide
// limit() ile belilioruz