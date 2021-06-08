public class FizzBuzz {
    public String fizzBuzz(int val){
        if(val % 3 == 0 && val % 5 == 0){
            return "Fizzbuzz";
        } else if (val % 3 == 0){
            return "Fizz";
        } else if(val % 5 == 0){
            return "Buzz";
        } else {
            return Integer.toString(val);
        }
    }
    public void counter(){
        for(int i = 1; i <= 20; i++){
            String result = fizzBuzz(i);
            System.out.println("Number" + i + "Result: " + result );
        }
    }
}