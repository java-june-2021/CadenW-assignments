public class PhoneTester {
    public static void main(String[] args) {
        Galaxy s9 = new Galaxy("S9", 99, "Verizon", "RING!");
        IPhone iphoneTen = new IPhone("X", 100, "ATT", "Zing Zing");
        s9.displayInfo();
        iphoneTen.displayInfo();
    }
}