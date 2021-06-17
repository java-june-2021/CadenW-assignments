public class Bat extends Mammal{
    Mammal bat = new Mammal();

    public Bat(){
        this.energyLevel = 300;
    }
    public void fly(){
        System.out.println("(sounds of a bat flying)");
        this.setEnergy(this.getEnergy() - 50);
        System.out.println(this.getEnergy());
    }
    public void eatHumans(){
        System.out.println("I want to suck your blood!");
        this.setEnergy(this.getEnergy() + 25);
        System.out.println(this.getEnergy());
    }
    public void attackTown(){
        System.out.println("Destroying this town it will be the new Transylvania");
        this.setEnergy(this.getEnergy() - 100);
        System.out.println(this.getEnergy());
    }

}