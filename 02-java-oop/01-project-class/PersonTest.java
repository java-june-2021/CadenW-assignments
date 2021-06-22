public class PersonTest{
    public static void main(String[] args) {
        Person caden = new Person("Caden Wilcox", "caden@c.com", "Music", 23);
        Person billy = new Person("Billy the kid", "billy@b.com");
        caden.getName();
        caden.getEmail();
        caden.getHobby();
        billy.getName();
        billy.getEmail();
        billy.getHobby();
        caden.battle(billy, "Water Gun");
        billy.getHealth();



    }
}