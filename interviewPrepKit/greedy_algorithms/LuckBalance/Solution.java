package interviewPrepKit.greedy_algorithms.LuckBalance;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Solution {


    // Complete the luckBalance function below.
    /**
     * too hard to simplify, refer to link:
     * https://www.hackerrank.com/challenges/luck-balance
     * @param k
     * @param contests
     * @return
     */
    static int luckBalance(int k, int[][] contests) {
        int totalLuck = 0;

        int importantContestCount = 0;
        for(int i = 0; i < contests.length; i++) {
            if(contests[i][1] == 1)
                importantContestCount++;
            // not important, we can close this contest and gain the luck
            else
                totalLuck += contests[i][0];
        }
        int[] importantContests = new int[importantContestCount];
        int j = 0;
        for(int i = 0; i < contests.length; i++)
            if(contests[i][1] == 1)
                importantContests[j++] = contests[i][0];

        // sorted lowest to greatest
        Arrays.sort(importantContests);

        int contestsToWin = importantContestCount-k;
        for(int i = 0; i < importantContestCount;i++) {
            if(contestsToWin > 0) {
                totalLuck -= importantContests[i];
                contestsToWin--;
            }
            else
                totalLuck += importantContests[i];
        }

        return totalLuck;
    }
    

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(new FileReader(args[0]));


            int rows = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] contests = new int[rows][2];
            for(int i = 0; i < rows; i++) {
                contests[i][0] = scanner.nextInt();
                contests[i][1] = scanner.nextInt();
            }

            long startTime = System.nanoTime();
            long endTime = System.nanoTime();


            System.out.println( luckBalance(k, contests) );


            System.out.println("The code took this long to execute: " + (endTime - startTime) );


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return;


    }
}


