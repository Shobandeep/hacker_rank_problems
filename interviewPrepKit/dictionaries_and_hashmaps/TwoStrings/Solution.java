package interviewPrepKit.dictionaries_and_hashmaps.TwoStrings;

// import java.util.HashMap;

public class Solution {

    // Complete the twoStrings function below.
    // oh no! was I supposed to use a hash? >:)
    static String twoStrings(String s1, String s2) {
        char[] ascii = new char[128];

        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();

        for(int i = 0; i < s1Array.length; i++) {
            ascii[s1Array[i]]++;
        }

        for(int i = 0; i < s2Array.length; i++) {
            if(ascii[s2Array[i]] != 0)
                return "YES";

        }
        return "NO";
    }


    public static void main(String[] args) {

        String s1 = "hello";
        String s2 = "world";


        long startTime = System.nanoTime();

        long endTime = System.nanoTime();
        System.out.println( twoStrings(s1, s2) );
        System.out.println("The code took this long to execute: " + (endTime - startTime) );
    }
}



