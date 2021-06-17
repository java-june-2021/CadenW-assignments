public class Mammal {
    private int energyLevel;

    public Mammal(){
        this.energyLevel = 100;
    }

    public int displayEnergy(){
        System.out.println(energyLevel);
        return energyLevel;
    }
    public int getEnergy(){
        return this.energyLevel;
    }
    public void setEnergy(int energyLevel){
        if (energyLevel <= 0){
            System.out.println("I'm all out of energy");
            return;
        }
        this.energyLevel = energyLevel;
    }

}