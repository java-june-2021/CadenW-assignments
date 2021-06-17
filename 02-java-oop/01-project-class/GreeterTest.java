public class GreeterTest{
    public static void main(String[] args) {
        Greeter g = new Greeter();

        String greeting = g.greet();
        String greetingWithName = g.greet();
        System.out.println(greetingWithName);

        // if (greeting.equals("Hello World") || greetingWithName.equals("Hello Caden")){
        //     System.out.println("Test Successful");
        // } else{
        //     System.out.println("Test Fail");
        // }
    }
}