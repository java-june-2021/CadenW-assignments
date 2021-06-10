import java.util.ArrayList;
// Print 1 to 255 
public class Basics {
    public void print1To255 (){
        for(int i = 1; i < 256; i++){
            System.out.println(i);
        }
    }
    // print odd numbers from 1 to 255 
    public void printOddTo255 (){
        for (int i = 1; i < 256; i += 2){
            System.out.println(i);
        }
    }
    // print all numbers 1-255 and sum the numbers together 
    public void sumTo255(){
        int sum = 0;
        for (int i = 0; i < 256; i++){
            sum += i;
            System.out.println("New Number: " + i  +  " Sum is: " + sum);
        }
    }
    // itterate through an array and print each index in the array 
    public void iterateArray(int [] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    // find the max number in an array 
    public void findMax(int [] array){
        int max = array[0];
        for (int i = 1; i < array.length; i++){
            if (array[i] > max){
                max = array[i];
            }
        }
        System.out.println(max);
    }
    // find the average of an array 
    public void findAverage(int [] arr){
        double sum = 0;
        for (int i = 0; i < arr.length; i ++){
            sum += arr[i];
        }
        double average = sum/arr.length;
        System.out.println(average);
    }
    // Array with Odd Numbers
    // Write a method that creates an ArrayList 'y' that contains all the odd numbers between 1 to 255. When the method is done, 'y' should have the value of [1, 3, 5, 7, ... 255].
    public ArrayList arrayOddNumbers(){
        ArrayList<Integer> y = new ArrayList<Integer>();
        for (int i = 1; i < 256; i += 2){
            y.add(i);
        }
        return y;
    }
    // Write a method that takes an array and returns the number of values in that array whose value is greater than a given value y. For example, if array = [1, 3, 5, 7] and y = 3, after your method is run it will print 2 (since there are two values in the array that are greater than 3).
    public Integer greaterThanY(int [] arr, int y){
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > y){
                count++;
            }
        }
        System.out.println(count);
        return count;
    }
    // Given any array x, say [1, 5, 10, -2], write a method that multiplies each value in the array by itself. When the method is done, the array x should have values that have been squared, say [1, 25, 100, 4].
    public int[] squareValues(int[] arr){
        for (int i = 0; i < arr.length; i++){
            arr[i] = arr[i] * arr[i];
        }
        return arr;
    }
    // Given any array x, say [1, 5, 10, -2], write a method that replaces any negative number with the value of 0. When the method is done, x should have no negative values, say [1, 5, 10, 0].
    public int[] noNegatives(int[] arr){
        for (int i =0; i < arr.length; i++){
            if(arr[i] < 0){
                arr[i] = 0;
            }
        }
        return arr;
    }
    // Given any array x, say [1, 5, 10, -2], write a method that returns an array with the maximum number in the array, the minimum value in the array, and the average of the values in the array. The returned array should be three elements long and contain: min max and avg
    public ArrayList minMaxAvg(int[] arr){
        int max = arr[0];
        int min = arr[0];
        double sum = 0;
        ArrayList<Object> list = new ArrayList<Object>();
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > max){
                max = arr[i];
            }
            else if (arr[i] < min){
                min = arr[i];
            }
            sum += arr[i];
        }
        double avg = sum/arr.length;
        list.add(max);
        list.add(min);
        list.add(avg);
        return list;
    }
    // Given any array x, say [1, 5, 10, 7, -2], write a method that shifts each number by one to the front. For example, when the method is done, an x of [1, 5, 10, 7, -2] should become [5, 10, 7, -2, 0]. Notice that the last number is 0. The method does not need to wrap around the values shifted out of bounds.
    public int[] shiftValues(int[] arr){
        for (int i = 0; i < arr.length-1; i++){
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = 0;
        return arr;
    }

}