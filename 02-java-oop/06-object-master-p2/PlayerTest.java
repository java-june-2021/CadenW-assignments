public class PlayerTest{
    public static void main(String[] args) {
        Human human1 = new Human();
        Human human2 = new Human();
        Ninja ninja1 = new Ninja();
        Samurai sam1 = new Samurai();
        Samurai sam2 = new Samurai();
        Samurai sam3 = new Samurai();
        Wizard wiz1 = new Wizard();


        // Testing Human class 
        
        human1.setHealth(150);
        human1.setIntel(5);
        human1.setStealth(5);
        human1.setStrength(5);
        human1.getHealth();
        human1.getIntel();
        human1.getStealth();
        human1.getStrength();
        human1.attack(human2);
        human1.getHealth();
        human2.getHealth();

        // testing Ninja class

        ninja1.steal(human1);
        human1.getHealth();
        ninja1.getHealth();
        ninja1.runAway();
        ninja1.getHealth();

        // Testing Samurai class

        sam1.deathBlow(human1);
        sam1.getHealth();
        human1.getHealth();
        sam1.meditate();
        sam1.getHealth();
        System.out.println(sam1.getCount());
        System.out.println(sam3.getCount());


        // tesing Wizard class 
        wiz1.getHealth();
        wiz1.getIntel();
        wiz1.heal(human1);
        human1.getHealth();
        human1.setHealth(150);
        wiz1.fireball(human1);
        human1.getHealth();







    }
}