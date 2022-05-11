package lambda_practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C3_Array_StreamOrnekleri {
    public static void main(String[] args) {

        // Arraylerde Stream kullanabilmek icin 2 yol vardir
            // 1) Stream <Integer> isim=StreamOf(cevrilecek olan) -> Stream objesi
            // 2) Arrays.stream(arr).  ->  Array sinifindan yararlanarak
        //Array ler collection sinifinda degillerdir..set ve MAp ler gibi degildir..
        // kullanabilmek icin donusum yapilmalidir

        Integer arr1 [] ={1,5,-5,6,12,-8,9,3,4};
        int arr2 [] ={1,5,-5,6,12,-8,9,3,4};
        System.out.println("S1 --> "+listeleArray(arr1));
        System.out.println("S2 --> "+arrayTopla(arr2));
        System.out.println("S3 --> ");
        arrayOrtalama(arr2);
        System.out.println("S4 --> ");
        arrayBuyuk(arr2);




    }
    //S1: arrayin elemanlarini bir liste yazdiralim
    public static List<Integer> listeleArray(Integer[] arr1) {
        return Arrays.stream(arr1).collect(Collectors.toList());
    }

    //S2: Arrayin elemanlarini toplamini bulalim
    public static int arrayTopla(int[] arr1) {
        //return Arrays.stream(arr1).reduce(0,(x,y)->x+y);
        return Arrays.stream(arr1).sum();
    }

    // S3: Array in elemanlarinin ortalamasini bulalim yazdir
    public static void arrayOrtalama(int[] arr) {
        Arrays.stream(arr).average().ifPresent(System.out::println);
    }


    // S4: Array in en büyük elemanını bulalim
    public static void arrayBuyuk(int[] arr) {
        Arrays.stream(arr).reduce(Math::max).ifPresent(System.out::println);
    }


}
