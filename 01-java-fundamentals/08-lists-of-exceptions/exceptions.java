import java.util.ArrayList;

public class exceptions{
    public ArrayList exceptions(){
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");
        for(int i = 0; i < myList.size(); i++) {
            try {
                Integer castedValue = (Integer) myList.get(i);
                System.out.println(myList.get(i) + " Success!");
            } catch (Exception e) {
                System.out.println("Error At " + myList.get(i));
            }
        }
        return myList;
    }
}