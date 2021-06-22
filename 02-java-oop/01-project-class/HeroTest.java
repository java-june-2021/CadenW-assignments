public class HeroTest{
    public static void main(String[] args) {
        Hero peasant = new Hero("Edward", 25, 50, 45);
        Knight k = new Knight();
        peasant.setStr(30);
        peasant.setName("edward");
        peasant.setHealth(48);
        System.out.println(peasant.getStr());
        System.out.println(peasant.getName());
        System.out.println(peasant.getHealth());
        System.out.println(k.getName());
        System.out.println(k.getStr());
        System.out.println(k.getStamina());
        System.out.println(k.getHealth());


    }
}