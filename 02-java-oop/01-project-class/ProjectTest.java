public class ProjectTest {
    public static void main(String[] args) {
        Project test = new Project();
        Project test2 = new Project("Jordans Website");
        Project test3 = new Project("Scary Terry's FunHouse", "Be careful of Scary Terry");

        System.out.println(test.getName());
        System.out.println(test2.getName());
        System.out.println(test3.getName());
        System.out.println(test.getDescription());
        System.out.println(test2.getDescription());
        System.out.println(test3.getDescription());
        test2.setName("Bo");
        test2.setName("Bob's Website");
        System.out.println(test2.getName());


    }
}