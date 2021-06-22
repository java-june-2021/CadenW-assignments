public class Pokemon{
    private String name;
    private int health;
    private String type;
    private static int numberOfPokemon;


    public Pokemon(String name, int health, String type){
        this.name = name;
        this.health = health;
        this.type = type;
        numberOfPokemon ++;
    }
    public static int numOfPokemon(){
        System.out.println(numberOfPokemon);
        return numberOfPokemon;
    }
    public String getName(){
        System.out.println(name);
        return this.name;
    }
    public int getHealth(){
        System.out.println(health);
        return this.health;
    }
    public String getType(){
        System.out.println(type);
        return this.type;
    }
    // Setters
    public void setName(String name){
        this.name = name;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public void setType(String type){
        this.type = type;
    }
    // Attack method to attack another pokemon 
    public void attackPokemon(Pokemon pokemon){
        pokemon.health -= 10;

    }
}