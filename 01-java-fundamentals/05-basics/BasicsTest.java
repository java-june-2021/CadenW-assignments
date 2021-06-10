import java.util.ArrayList;
import java.util.Arrays;

public class BasicsTest {
    public static void main(String[] args){
        Basics object = new Basics();
        object.print1To255();

        object.printOddTo255();

        object.sumTo255();

        int [] arr = {1,3,5,7,9,13};
        object.iterateArray(arr);

        int [] array = {-1,1,4,-6,-100,99,100,87,-89};
        object.findMax(array);

        int [] array2 = {1,2,3,4,5};
        object.findAverage(array2);

        ArrayList<Integer> arrOfOdd = new ArrayList<Integer>();
        arrOfOdd = object.arrayOddNumbers();
        System.out.println (arrOfOdd);

        int [] array3 = {1,3,5,7};
        int total = object.greaterThanY(array3, 3);

        int [] array4 = {1,5,10,-2};
        object.squareValues(array4);
        System.out.println(Arrays.toString(array4));

        int [] array5 = {1,5,10,-2};
        object.noNegatives(array5);
        System.out.println(Arrays.toString(array5));

        int [] array6 = {1,5,10,-2};
        ArrayList<Object> minMaxAvg = new ArrayList<Object>();
        minMaxAvg = object.minMaxAvg(array6);
        System.out.println(minMaxAvg);

        int [] array7 = {1,5,7,10,-2};
        object.shiftValues(array7);
        System.out.println(Arrays.toString(array7));
    }
}