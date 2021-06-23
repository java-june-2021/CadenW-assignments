public class HeroTest{
    public static void main(String[] args) {
        Hero warrior = new Hero("Edward The Warrior", 200, 100, 450);
        Knight k = new Knight();
        Hero peasant = new Hero("Tommy the Kid", 50, 40, 50);
        System.out.println(warrior.getStr());
        System.out.println(warrior.getName());
        System.out.println(warrior.getHealth());
        System.out.println(k.getName());
        System.out.println(k.getStr());
        System.out.println(k.getStamina());
        System.out.println(k.getHealth());
        warrior.attack(k, "Water Gun");
        System.out.println(k.getHealth());
        k.attack(warrior, "Body Slam");
        System.out.println(warrior.getHealth());
        warrior.attack(peasant, "Water Gun");
        System.out.println(peasant.getHealth());


        




    }
}