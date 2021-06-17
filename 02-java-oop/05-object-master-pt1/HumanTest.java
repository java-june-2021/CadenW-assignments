public class HumanTest{
    public static void main(String[] args) {
        Human human1 = new Human();
        Human human2 = new Human();

        human1.attack(human2);
        human2.getHealth();
        human1.getHealth();
        human1.getStrength();
        human2.setStrength(50);
        human2.getStrength();
        human2.attack(human1);
        human1.getHealth();
        human1.setIntel(109);
        human1.getIntel();
        

    }
}