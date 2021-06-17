public class Gorilla extends Mammal {
    Mammal gorilla = new Mammal();

    public void throwSomething(){
        System.out.println("This Gorilla is throwing poo at you watch out!");
        this.setEnergy(this.getEnergy() - 5);
        System.out.println(this.getEnergy());

    }
    public void eatBananas(){
        System.out.println("This Gorilla is eating a banana!");
        this.setEnergy(this.getEnergy() + 10);
        System.out.println(this.getEnergy());
    }

    public void climb(){
        System.out.println("Gorilla is climbing a tree");
        this.setEnergy(this.getEnergy() - 10);
        System.out.println(this.getEnergy());
    }

}