package interviewPrepKit.sorting.FraudulentActivity;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Solution {

    // Complete the activityNotifications function below.

    /**
     * activityNotifications monitors a history of transactions and outputs the total
     * number of transactions that are suspicious ( [median of previous d transactions]*2 <= n) over a given period d.
     * the method uses frequency sort to keep a running list of previous transactions to keep resorting to a minimum.
     *
     * Constraints:
     *  1 <= expenditure.length <= 2 * 10^5
     *  expenditure[i] <= 200
     *  1 <= d <= expenditure.length
     *
     * @param expenditure - the history of transactions, in dollar amounts
     * @param d - the period of time to observe for suspicious transactions
     * @return the total number of suspicious transactions
     */
    static int activityNotifications(int[] expenditure, int d) {
        int notifications = 0;
        int[] freqCount = new int[200];
        int[] sortedHistory = new int[d];
        // left over from the counting  sort attempt
//        int startingPoint = 0;
        boolean isEven = d % 2 == 0;

        // initially populate freqCount
        for(int i = 0; i < d;i++)
            freqCount[expenditure[i]]++;

        for(int i = d; i < expenditure.length; i++) {
            // recalculate the frequency (left over from the counting  sort attempt)
//            for(int j = startingPoint; j < freqCount.length-1; j++)
//                freqCount[j+1] += freqCount[j];



            // create the sorted transaction history
            for(int j = 0, k = 0; j < freqCount.length; j++) {
                int count = freqCount[j];
                while(count != 0) {
                    sortedHistory[k++] = j;
                    count--;
                }
            }

            double median = isEven ? ((float)sortedHistory[d/2 - 1] + sortedHistory[d/2]) / 2 : sortedHistory[d/2];


//            debug
//            for(int j = i-d; j < i; j++)
//                System.out.print(expenditure[j] + " ");
//            System.out.println();
//            for(int j = 0; j < sortedHistory.length; j++)
//                System.out.print(sortedHistory[j] + " ");
//            System.out.println();
//            System.out.println("median:"+ median + " n:" + expenditure[i]);

            if(expenditure[i] >= (median*2))
                notifications++;

            int oldestTransaction = expenditure[i-d];
            int newestTransaction = expenditure[i];

            
           // remove the oldest transaction
           freqCount[oldestTransaction]--;
           // add the newest
           freqCount[newestTransaction]++;

           // left over from the counting  sort attempt
//            // update startingPoint so we don't recalculate from 0 everytime
//            startingPoint = Math.min(oldestTransaction, newestTransaction);
        }

        return notifications;
    }




    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(new FileReader(args[0]));

            int length = scanner.nextInt();
            int trailing = scanner.nextInt();

            int[] purchases = new int[length];

            for(int i = 0; i < length; i++)
                purchases[i] = scanner.nextInt();



            long startTime = System.nanoTime();
            long endTime = System.nanoTime();

            System.out.println( activityNotifications(purchases, trailing) );
            System.out.println("The code took this long to execute: " + (endTime - startTime) );



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return;


    }
}


