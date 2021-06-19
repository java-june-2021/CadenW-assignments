public class Samurai extends Human {
    Human samurai = new Human();
    public static int counter = 0;


    public Samurai(){
        counter ++;
        this.health = 200;

    }
    public void deathBlow(Human target){
        target.health -= target.health;
        this.health = this.health/2;
    }
    public void meditate(){
        this.health += this.health/2;

    }
    public int getCount(){
        return counter;
        
    }
}