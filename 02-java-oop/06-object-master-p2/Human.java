public class Human{
    public int strength = 3;
    public int stealth = 3;
    public int intel = 3;
    public int health = 100;
    
    // Methods 
    public void attack(Human enemy){
        enemy.health -= this.strength;
    }

    // Getters
    public int getHealth(){
        System.out.println(health);
        return this.health;
    }
    public int getStrength(){
        System.out.println(strength);
        return this.strength;
    }
    public int getStealth(){
        System.out.println(stealth);
        return this.stealth;
    }
    public int getIntel(){
        System.out.println(intel);
        return this.intel;
    }
    // Setters
    public void setHealth(int health){
        this.health = health;
    }
    public void setStrength(int strength){
        this.strength = strength;
    }
    public void setStealth(int stealth){
        this.stealth = stealth;
    }

    public void setIntel(int intel){
        this.intel = intel;
    }


}