package interviewPrepKit.dictionaries_and_hashmaps.FrequencyQueries;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        // will contain numbers and their count
        HashMap<Integer, Integer> integerMap = new HashMap<>();
        // will keep track of frequency of numbers
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(List<Integer> query : queries) {
            int command = query.get(0);
            int value = query.get(1);
            int count, freqCountPrev, freqCountNext;
            switch (command) {
                case 1: // add value
                    count = integerMap.getOrDefault(value, 0);
                    freqCountPrev = frequencyMap.getOrDefault(count, 0);
                    freqCountNext = frequencyMap.getOrDefault(count+1, 0);

                    integerMap.put(value, count+1);

                    frequencyMap.put(count, freqCountPrev-1);
                    frequencyMap.put(count+1, freqCountNext+1);

                    break;
                case 2: // remove value
                    count = integerMap.getOrDefault(value, 0);
                    freqCountPrev = frequencyMap.getOrDefault(count, 0);
                    freqCountNext = frequencyMap.getOrDefault(count-1, 0);
                    if(count != 0) {
                        integerMap.put(value, count-1);

                        frequencyMap.put(count, freqCountPrev-1);
                        frequencyMap.put(count-1, freqCountNext+1);
                    }
                    break;
                case 3: // check frequency
                    int hasFrequency = frequencyMap.getOrDefault(value, 0);
                    if(hasFrequency > 0) {
                        result.add(1);
                    } else
                        result.add(0);
                    break;
            }
        }
        return result;
    }



    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(new FileReader(args[0]));

            List<List<Integer>> list = new ArrayList<>();
            // long length = scanner.nextInt();

            while(scanner.hasNext()) {
                List<Integer> queryList = new ArrayList<>();
                queryList.add(scanner.nextInt());
                queryList.add(scanner.nextInt());
                list.add(queryList);
            }



            long startTime = System.nanoTime();
            long endTime = System.nanoTime();

            System.out.println( freqQuery(list).toString() );
            System.out.println("The code took this long to execute: " + (endTime - startTime) );



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return;


    }
}


