package interviewPrepKit.sorting.FraudulentActivity;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Solution {

    // Complete the activityNotifications function below.
    static int tookTooLong(int[] expenditure, int d) {
        int notifications = 0;
        for(int i = d; i < expenditure.length-1; i++) {
            double avg = expenditure[i-d];
            for(int j = i-(d-1); j < i; j++) {
                avg = (expenditure[j] + avg ) / 2;
            }

            double median = expenditure[i-d];
            if(expenditure.length % 2 == 1) {
                for(int j = i-(d-1); j < i; j++) {
                    if( Math.abs(median-avg) > Math.abs(expenditure[j]-avg))
                        median = expenditure[j];
                }
                if(expenditure[i] >= (median * 2))
                    notifications++;
            }
            else {
                double otherMedian = 0;
                for(int j = i-(d-1); j < i; j++) {
                    if( Math.abs(median-avg) >= Math.abs(expenditure[j]-avg)) {
                        otherMedian = median;
                        median = expenditure[j];
                    }

                }
                median = (median + otherMedian) / 2;
                if(expenditure[i] >= (median * 2))
                    notifications++;
            }
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

            // System.out.println( activityNotifications(purchases, trailing) );
            System.out.println("The code took this long to execute: " + (endTime - startTime) );



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return;


    }
}


