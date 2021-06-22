public class Hero {
    private String name;
    private int str;
    private int stamina;
    private int health;

    public Hero(String name, int str, int stamina, int health){
        this.name = name;
        this.str = str;
        this.stamina = stamina;
        this.health = health;
    }
    // Getters

    public String getName(){
        return this.name;
    }
    public int getStr(){
        return this.str;
    }
    public int getStamina(){
        return this.stamina;
    }
    public int getHealth(){
        return this.health;
    }
    // Setters

    public void setName(String name){
        this.name = name;
    }
    public void setStr(int str){
        this.str = str;
    }
    public void setStamina(int stamina){
        this.stamina = stamina;
    }
    public void setHealth(int health){
        this.health = health;
    }
}