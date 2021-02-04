package interviewPrepKit.dictionaries_and_hashmaps.CountTriplets;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.*;

public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        long tripletCount = 0;
        HashMap<Long, Long> singleNumMap = new HashMap<>();
        HashMap<Long, Long> pairsMap = new HashMap<>();


        for(int i = arr.size()-1; i >= 0; i--) {
            Long currentNumber = arr.get(i);
            Long nextNumber = currentNumber * r;

            Long currentNumberFreq = singleNumMap.get(currentNumber);
            Long nextNumberFreq = singleNumMap.get(nextNumber);



            // if a pair exists, we have a triplet
            Long pairCount = pairsMap.get(nextNumber);
            if(pairCount != null) {
                tripletCount += pairCount;
            }

            // if we came across the next number in the geometric progression (num * r) before, we now have a
            // pair of this number and need to add it to the pairs mapping, update / add it
            if(nextNumberFreq != null) {
                Long currentPairFreq = pairsMap.get(currentNumber);
                if(currentPairFreq == null)
                    pairsMap.put(currentNumber, nextNumberFreq);
                else
                pairsMap.put(currentNumber, currentPairFreq + nextNumberFreq);
            }


            // note current number being processed
            if(currentNumberFreq == null) {
                singleNumMap.put(currentNumber, 1l);
            }
            else {
                singleNumMap.put(currentNumber, currentNumberFreq+1);
            }
        }

        return tripletCount;
    }
    

    // Complete the countTriplets function below.
    static long aVerySadAttempt(List<Long> arr, long r) {
        long tripletCount = 0;
        HashMap<Long, Long> map = new HashMap<>();

        if(r == 1) {
            return nCr(arr.size(), 3);
        }

        for(int i = arr.size()-1; i >= 0; i--) {
            Long num    = arr.get(i);
            long secondKey = num * r;
            long thirdKey  = secondKey * r;

            Long second = map.get(secondKey);
            Long third = map.get(thirdKey);
            if(second != null && third != null) {
                if(r == 1)
                    tripletCount++;
                tripletCount += second * third;
            }

            Long numCount = map.get(num);
            if(numCount == null)
                map.put(num, 1l);
            else
                map.put(num, numCount+1);
        }

        return tripletCount;
    }

    static long nCr(int n, int r)
    {
        BigInteger top = fact(n);
        BigInteger bottom = fact(r).multiply(fact(n-r));
        return top.divide(bottom).longValue();
    }

    // Returns factorial of n
    static BigInteger fact(int n)
    {
        BigInteger res = new BigInteger(n+"");
        for (int i = 2; i < n; i++) {
            res = res.multiply(new BigInteger(i + ""));
        }
        return res;
    }


    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(new FileReader(args[0]));

            List<Long> list = new ArrayList<>();
            // long length = scanner.nextInt();
            long r = scanner.nextLong();

            while(scanner.hasNext()) {
                list.add(scanner.nextLong());
            }



            long startTime = System.nanoTime();
            long endTime = System.nanoTime();

            System.out.println( countTriplets(list, r) );
            System.out.println("The code took this long to execute: " + (endTime - startTime) );



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return;


    }
}




