public class StringManipulator {
    public String trimAndConcatString(String stringA, String stringB){
        return stringA.trim() + stringB.trim();
    }
    public Integer getIndexOrNull(String fullString, String secondString){
        Integer indexA = fullString.indexOf(secondString);
        if (indexA >= 0){
            return indexA;
        } else {
            return null;
        }
    }
    public String concatSubstring(String firstString, int start, int end, String secondString){
        String newString = firstString.substring(start, end);
        return newString + secondString;
    }
}