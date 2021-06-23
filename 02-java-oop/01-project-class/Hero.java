public class Hero {
    protected String name;
    protected int str;
    protected int stamina;
    protected int health;

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
    public void attack(Hero target, String powerMove){
        int damage = 0;
        if (powerMove.equals("Body Slam")){
            damage = 3 + this.str;
        } else if (powerMove.equals("Eye Lazers")){
            damage = 5 + this.str;
        } else if (powerMove.equals("Water Gun")){
            damage = 8 + this.str;
        } else{
            System.out.println("Move Not Learned Yet :(");
        }
        if ((target.getHealth() - damage) <= 0){
            System.out.printf("%s defeated %s with %s his time is up \n", this.name, target.name, powerMove);
            return;

        } else{
            target.setHealth(target.getHealth() - damage);
            System.out.printf("%s battles %s; used %s and dealt %d damage \n", this.name, target.name, powerMove, damage);
        }
    }
}