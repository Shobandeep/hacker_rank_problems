package interviewPrepKit.arrays.MinimumBribes;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int bribeCount = 0;

        for(int i = 0; i < q.length; i++) {
            int deltaPosition = q[i] - (i+1);
            if( deltaPosition > 2) {
                System.out.println("Too chaotic");
                return;
            }
            for(int j = Math.max(0, q[i]-2); j < i; j++) {
                // if someone with a higher sticker number is front, this person has taken a bribe
                if(q[j] > q[i])
                    bribeCount++;
            }
        }


        System.out.println(bribeCount);
    }

    static void minimumBribesBackwards(int[] q) {
        int bribeCount = 0;

        for(int j = q.length; j > 0; j--) {
            int index = 0;
            // find the index of this sticker
            while(j != q[index]) index++;

            // if the sticker is >2 away from it's position, there were too many bribes
            int deltaPosition = j - (index+1);
            if( deltaPosition > 2) {
                System.out.println("Too chaotic");
                return;
            }
            // do nothing if they haven't moved
            else if(deltaPosition == 0)
                continue;

            // reverse the bribes until this person is back in
            // their original position
            while(q[j-1] != j) {
                q[index] = q[index+1];
                q[index+1] = j;
                index++;
                bribeCount++;
            }
        }

        System.out.println(bribeCount);
    }

    public static void main(String[] args) {

        int[] q = {2, 1, 5, 3, 4};
        // int[] q = {1, 2, 5, 3, 7, 8, 6, 4};
        // int[] q = {2, 5, 1, 3, 4};

        minimumBribes(q);
    }
}


