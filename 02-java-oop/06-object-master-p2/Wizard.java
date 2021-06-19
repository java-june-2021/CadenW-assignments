public class Wizard extends Human{


    public Wizard(){
        this.intel = 8;
        this.health = 50;
    }
    public void heal(Human toBeHealed){
        toBeHealed.health += this.intel;
    }
    public void fireball(Human target){
        target.health -= (this.intel * 3);
    }


}