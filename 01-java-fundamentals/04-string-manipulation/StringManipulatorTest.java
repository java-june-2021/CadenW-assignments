public class StringManipulatorTest {
    public static void main(String[] args){
        StringManipulator manipulator = new StringManipulator();
        String testA = manipulator.trimAndConcatString("   Caden   " , "   Wilcox   ");
        System.out.println(testA);
        Integer testB = manipulator.getIndexOrNull("Caden" , "en");
        System.out.println(testB);
        Integer testC = manipulator.getIndexOrNull("Caden" , "Wi");
        System.out.println(testC);
        String word = manipulator.concatSubstring("Hello", 1, 2, "World");
        System.out.println(word);
    }
}