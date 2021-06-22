// creating the class Person named the exact same as the file name - .java of course
public class Person {
    // these are the attributes or member variables that are applied to the person class 
    private String name;
    private String email;
    private String favoriteHobby;
    private int health;
    private static int numberOfPeople;



    // this is example of constructors and overloading methods 
    public Person(String name, String email, String favoriteHobby, int age){
        this.name = name;
        this.email = email;
        this.favoriteHobby = favoriteHobby;
        this.health = health;
        numberOfPeople ++;
    }
    // I have 2 ways to instantiate a person object one with all 4 parameters and this one below with 2 when i instantiate in my test file the computer will know based on how many arguments i put in which method to use 

    public Person(String name, String email){
        this.name = name;
        this.email = email;
        this.favoriteHobby = "No Hobbies";
        this.health = 100;
        numberOfPeople ++;
    }

    // Next we have Getters and setters which are methods to either get one or more of the attributes printed to the console setters are to re set one or more of the attributes 
    public String getName(){
        System.out.println(name);
        return this.name;
    }
    public String getEmail(){
        System.out.println(email);
        return this.email;
    }
    public String getHobby(){
        System.out.println(favoriteHobby);
        return this.favoriteHobby;
    }
    public int getHealth(){
        System.out.println(health);
        return this.health;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setHobby(String hobby){
        this.favoriteHobby = favoriteHobby;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public void battle(Person target, String powerMove){
        int damage = 0;
        if (powerMove.equals("Body Slam")){
            damage = 5;
        } else if (powerMove.equals("Eye Lazers")){
            damage = 10;
        } else if (powerMove.equals("Water Gun")){
            damage = 15;
        } else{
            System.out.println("Move Not Learned Yet :(");
        }
        target.setHealth(target.getHealth() - damage);
        System.out.printf("%s battles %s; used %s and dealt %d damage \n", this.name, target.name, powerMove, damage);
    }


}