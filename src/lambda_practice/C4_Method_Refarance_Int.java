package lambda_practice;

// lambda da method kullanimi :
//ilk olarak class adi yazilir
//sonra  :: noktalar konur
//son olarak method secilir
//String class i sayesinde length gibi touppercase gibi methodlari kullanabiliriz
//Math classi sayesinde de sum vb methodlar kullanabiliriz

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class C4_Method_Refarance_Int {
    public static void main(String[] args) {
        List<Integer> intL= Arrays.asList(-2,-8,-5,0,2,5,6,7,15,6,8);

        System.out.println("S1");
        tekYazdir(intL);
        System.out.println("S2");
        ciftCarp(intL);
        System.out.println("S3");
        negatifKareTopla(intL);
        System.out.println("S4");
        pozitifKupMax(intL);

    }


    // S1: tekleri aralarinda bir bosluk birakarak yazdiralim
    private static void tekYazdir(List<Integer> L) {
        L.stream().filter(Methods::tekMi).forEach(t->System.out.print(t+" "));
    }

    // S2: ciftlein carpimini bulalim
    private static void ciftCarp(List<Integer> L) {
        L.stream().filter(Methods::ciftMi).map(t->t*t).forEach(t->System.out.print(t+" "));
    }

    // S3: negatiflerin kare toplamlarini  bulalim
    private static void negatifKareTopla(List<Integer> L) {
        System.out.println(L.stream().filter(Methods::negatifMi).map(t -> t * t).reduce(Integer::sum).get());
    }

    // S4: poziflerin kuplerinden max yazdiralim
    private static void pozitifKupMax(List<Integer> L) {
        System.out.println(L.stream().filter(Methods::pozitifMi).map(t -> t * t*t).reduce(Integer::max).get());
    }


}
