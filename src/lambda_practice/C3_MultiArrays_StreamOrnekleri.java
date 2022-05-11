package lambda_practice;
//multi arrayleri cevirirken flapMap kullaniriz yapilis sekli iki turludur
//1) lamda kullanarak
// Arrays.stream(arr).flatMap(t->Arrays.stream(t))
//2) method ile
// Arrays.stream(arr).flatMap(Arrays::stream)
// BU SEKLIDE ARTIK TUM STREAM METHODLARI KULLANILABILIR

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C3_MultiArrays_StreamOrnekleri {
    public static void main(String[] args) {
        String arr[][] = {
                {"Elma", "Muz"},
                {"Portakal", "Cilek", "Limon"},
                {"Havuc", "Erik"}
        };
        System.out.println(arrToList(arr));
        //System.out.println(eBaslayan(arr));

        eBaslayan(arr);
        yildizEkle(arr);

    }

    // S1 : tum elemanlari list yapayim
    public static List<String> arrToList(String[][] arr) {
        return Arrays.stream(arr).flatMap(t-> Arrays.stream(t)).collect(Collectors.toList());
    }


    // S2: E ile baslayan elemanlari double (elmaelma) olarak yazdiralim
    public static void eBaslayan(String[][] arr) {
       // return Arrays.stream(arr).flatMap(Arrays::stream).filter(t->t.startsWith("E")).map(t->t+t).collect(Collectors.toList());
    Arrays.stream(arr).flatMap(Arrays::stream).filter(t->t.startsWith("E")).map(t->t+t).forEach(System.out::println);
    }

    // S3: E ile baslayan elemanlari liste olarak yazdiralim


    //S4 : k ile bitenlerin sonuna '*' ekleyelim
    public static void yildizEkle(String[][] arr) {
        // return Arrays.stream(arr).flatMap(Arrays::stream).filter(t->t.startsWith("E")).map(t->t+t).collect(Collectors.toList());
        Arrays.stream(arr).flatMap(Arrays::stream).filter(t->t.endsWith("k")).map(t->t+" * ").forEach(System.out::println);
    }

}
