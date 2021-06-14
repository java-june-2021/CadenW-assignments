import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
public class PuzzleJava{
    // Create an array with the following values: 3,5,1,2,7,9,8,13,25,32. Print the sum of all numbers in the array. Also have the function return an array that only includes numbers that are greater than 10 (e.g. when you pass the array above, it should return an array with the values of 13,25,32)
    public ArrayList greaterThanTen(int[] arr){
        ArrayList<Integer> biggerThanTen = new ArrayList<Integer>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > 10){
                biggerThanTen.add(arr[i]);
            }
            sum += arr[i];
        }
        System.out.println(sum);
        return biggerThanTen;
    }

    // Create an array with the following values: Nancy, Jinichi, Fujibayashi, Momochi, Ishikawa. Shuffle the array and print the name of each person. Have the method also return an array with names that are longer than 5 characters.
    public ArrayList<String> shuffleNames(ArrayList<String> arr){
        ArrayList<String> names = new ArrayList<String>();
        Collections.shuffle(arr);
        for (int i = 0; i < arr.size(); i++){
            if (arr.get(i).length() > 5){
                names.add(arr.get(i));
            }
        }
        System.out.println(arr);
        return names;

    }
    //  Create an array that contains all 26 letters of the alphabet (this array must have 26 values). Shuffle the array and, after shuffling, display the last letter from the array. Have it also display the first letter of the array. If the first letter in the array is a vowel, have it display a message.
    public ArrayList<Character> alphabetShuffle(){
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (char ch = 'a'; ch <= 'z'; ch++){
            alphabet.add(ch);
        }
        Collections.shuffle(alphabet);
        System.out.println("the first letter is: " + alphabet.get(0));
        System.out.println("the last letter is: " + alphabet.get(25));
        char firstLetter = alphabet.get(0);
        char [] vowels = {'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < vowels.length; i++){
            if(vowels[i] == firstLetter){
                System.out.println("First Letter Is A Vowel");
            }
        }
        return alphabet;
    }
    // Generate and return an array with 10 random numbers between 55-100.
    public ArrayList randomNumbers(){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Random r = new Random();
        for (int i = 1; i < 11; i++){
            numbers.add(r.nextInt(46)+55);
        }
        return numbers;
    }
    //  Generate and return an array with 10 random numbers between 55-100 and have it be sorted (showing the smallest number in the beginning). Display all the numbers in the array. Next, display the minimum value in the array as well as the maximum value.
    public ArrayList randomNumbersTwo(){
        ArrayList<Integer> numbers2 = new ArrayList<Integer>();
        numbers2 = randomNumbers();
        Collections.sort(numbers2);
        int max = numbers2.get(0);
        int min = numbers2.get(0);
        for (int i : numbers2){
            if (i > max){
                max = i;
            }
            else if(i < min){
                min = i;
            }
        }
        System.out.println("Max value is: " + max);
        System.out.println("Min value is: " + min);
        return numbers2;
    }
    // Create a random string that is 5 characters long.
    public String randomString(){
        ArrayList<Character> alphabet = new ArrayList<Character>();
        Random r = new Random();
        for (char ch = 'a'; ch <= 'z'; ch++){
            alphabet.add(ch);
        }
        ArrayList<Character> randomLetters = new ArrayList<Character>();
        for (int i = 0; i < 6; i++){
            Character random = alphabet.get(r.nextInt(25));
            randomLetters.add(random);
        }
        String word = new String();
        word = randomLetters.get(0).toString() + randomLetters.get(1) + randomLetters.get(2) + randomLetters.get(3) + randomLetters.get(4);
        return word;
    }
    public ArrayList<String> tenRandom(){
        ArrayList<String> newString = new ArrayList<String>();
        for (int i = 0; i < 10; i++){
            newString.add(randomString());
        }
        return newString;
    }



}