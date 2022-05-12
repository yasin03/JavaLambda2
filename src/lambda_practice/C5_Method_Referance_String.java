package lambda_practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class C5_Method_Referance_String {
    public static void main(String[] args) {
        List<String> l= Arrays.asList("Elma", "Muz", "Portakal", "Cilek", "Limon");

        System.out.println("\nS1");
        buyukHarf(l);
        System.out.println("\nS2");
        siralaUzunluk(l);
        System.out.println("\nS3");
        eBaslayan(l);




    }


    // S1: Tum harfleri buyuk harf ile aralarinda bosluk birakarak yazdiralim
    private static void buyukHarf(List<String> l) {
        l.stream().map(t->t.toUpperCase().split(" ")).forEach(t->System.out.print(t+" "));
    }

    //S2: Stringleri uzunluklarina gore siralayip yaziniz
    private static void siralaUzunluk(List<String> l) {
        l.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(t-> System.out.print(t+" "));
    }

    //S3: E ILE Baslayanlari yazdiralim
    private static void eBaslayan(List<String> l) {
        l.stream().filter(t->t.toLowerCase().startsWith("e")).forEach(t-> System.out.print(t+" "));
    }

}
