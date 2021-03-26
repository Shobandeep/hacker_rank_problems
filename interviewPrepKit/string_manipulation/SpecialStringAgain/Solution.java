package interviewPrepKit.string_manipulation.SpecialStringAgain;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Solution {



    // Complete the substrCount function below.
    /// n^3 time, super long
//    static long tookTooLong(int n, String s) {
//        // at the very least, every single char matches a special string
//        long specialStringCount = n;
//        char[] charArray = s.toCharArray();
//
//        for(int length = 2; length < n+1; length++) {
//            for(int i = 0; (i+length) <= n; i++) {
//                char matcher = charArray[i];
//                int start = i, end = i+length-1;
//                boolean specialStringFound = true;
//                while(start < end) {
//                    if(charArray[start] != matcher || charArray[end] != matcher) {
//                        specialStringFound = false;
//                        break;
//                    }
//                    start++;
//                    end--;
//                }
//                if(specialStringFound) {
//                    specialStringCount++;
//                }
//            }
//        }
//
//        return specialStringCount;
//    }


    // Complete the substrCount function below.
    /**
     * method looks for substrings in the given string which match the following constraints:
     *  - all characters are either the same ex. 'aaaa'
     *  - or the middle character is different 'aabaa'
     *  NOTE: O(N) time!! :D
     * @param n
     * @param s
     * @return
     */
    static long substrCount(int n, String s) {
        long specialStringCount = 0;
        char[] charArray = s.toCharArray();

        char first = '0', second = '0', last = '0';
        long freqFirst = 0, freqSecond = 0, freqLast = 0;

        for(int i = 0; i < charArray.length;) {
            last = charArray[i];
            freqLast = 0;
            while(i != charArray.length && charArray[i] == last) {
                freqLast++;
                i++;
            }
            // (n * (n+1))/2 --> n + n-1 + n-2 ... + 1
            // aaa -> aaa + aa*2 + a*3
            specialStringCount += (freqLast * (freqLast+1)) / 2;
            // looking for pattern (a*)b(a*) * in this case is referring to kleene star
            if(first == last && freqSecond == 1)
                specialStringCount += Math.min(freqFirst, freqLast);
            // shift everything down for the next read
            first = second;
            freqFirst = freqSecond;
            second = last;
            freqSecond = freqLast;
        }

        return specialStringCount;
    }



    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(new FileReader(args[0]));

            long startTime = System.nanoTime();
            long endTime = System.nanoTime();


            int n = scanner.nextInt();
            String s = scanner.next();
            System.out.println(s.length());
            System.out.println( substrCount(n, s) );


            System.out.println("The code took this long to execute: " + (endTime - startTime) );


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return;


    }
}


