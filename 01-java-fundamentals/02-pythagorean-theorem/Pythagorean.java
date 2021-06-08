public class Pythagorean{
    public double calculateHyp(int a, int b){
        // define what hypotenuse is which is the third side of a right triangle using decimal cause answer could be a decimal 
        double sideC = 0.0;
        // int a is side a and int b is side b a sqrd + b sqrd is side c 
        sideC = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

        return sideC;
    }
}