package interviewPrepKit.string_manipulation.AlternatingCharacters;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Solution {

    // Complete the alternatingCharacters function below.
    /**
     * method looks for an alternating pattern between the Characters A and B
     * and counts the number of deletions required to conform to the pattern
     * @param s
     * @return
     */
    static int alternatingCharacters(String s) {
        int deleteCount = 0;
        char[] charArray = s.toCharArray();
        char currentChar = charArray[0];

        for(int i = 1; i < charArray.length; i++) {
            if(charArray[i] == currentChar)
                deleteCount++;
            else
                currentChar = charArray[i];
        }
        return deleteCount;
    }



    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(new FileReader(args[0]));

            int count = scanner.nextInt();

            for(int i = 0; i < count; i++) {
                String s = scanner.next();
                System.out.println(s);
                System.out.println( alternatingCharacters(s) );
            }

            long startTime = System.nanoTime();
            long endTime = System.nanoTime();

            System.out.println("The code took this long to execute: " + (endTime - startTime) );



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return;


    }
}


