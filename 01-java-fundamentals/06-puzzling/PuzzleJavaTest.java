import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
public class PuzzleJavaTest{
    public static void main(String[] args){
        PuzzleJava object = new PuzzleJava();

        int [] arr = {3,5,1,2,7,9,8,13,25,32};
        ArrayList<Integer> biggerThanTen = new ArrayList<Integer>();
        biggerThanTen = object.greaterThanTen(arr);
        System.out.println(biggerThanTen);

        ArrayList<String> arr2 = new ArrayList<String>();
        arr2.add("Nancy");
        arr2.add("Jinichi");
        arr2.add("Fujibayashi");
        arr2.add("Momochi");
        arr2.add("Ishikawa");
        System.out.println(object.shuffleNames(arr2));

        System.out.println(object.alphabetShuffle());

        System.out.println(object.randomNumbers());
        System.out.println(object.randomNumbersTwo());
        System.out.println(object.randomString());
        System.out.println(object.tenRandom());
    }
} 