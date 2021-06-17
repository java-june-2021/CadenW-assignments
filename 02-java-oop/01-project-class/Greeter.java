public class Greeter{
    public String greet(String name){
        return createGreeting(name);

    }
    public String greet(){
        return "Hello World";
    }
    public String greet(String firstName, String lastName){
        return createGreeting(firstName +" "+ lastName);
    }
    private String createGreeting(String toBeGreeted){
        return "Hello " + toBeGreeted;
    }
}