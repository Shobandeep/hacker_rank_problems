package interviewPrepKit.dictionaries_and_hashmaps.RansomeNote;

import java.util.HashMap;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : magazine) {
            Integer num = map.get(word);
            if(num != null) {
                map.put(word, num+1);
            }
            else {
                map.put(word, 1);
            }
        }

        for (String word : note) {
            Integer num = map.get(word);
            if(num == null) {
                System.out.println("No");
                return;
            }
            else if (num == 1) {
                map.remove(word);
            }
            else {
                map.put(word, num-1);
            }
        }
        System.out.println("Yes");
    }


    public static void main(String[] args) {

        String[] magazine = { "two", "times", "three", "is", "not", "four" };
        String[] note = { "two", "times", "two", "is", "four" };


        long startTime = System.nanoTime();
        checkMagazine(magazine, note);
        long endTime = System.nanoTime();
        System.out.println("The code took this long to execute: " + (endTime - startTime) );
    }
}



