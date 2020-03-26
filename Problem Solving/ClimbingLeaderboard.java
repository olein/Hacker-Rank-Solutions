import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ClimbingLeaderboard{

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice, int al) {
        HashSet<Integer> score = new HashSet<Integer>();
        HashSet<Integer> tempscore ;
        for(int i=0;i<scores.length;i++) score.add(scores[i]);        
        List<Integer> tempList;
        int index = -1;
        int[] res = new int[al];
        tempscore = new HashSet<Integer>(score);
        tempList = new ArrayList(tempscore);
        Collections.sort(tempList);
        int size = tempList.size();  
        int v,l,r,j;
        for(int i=0;i<al;i++) {
            index = size - 1;         
            v = alice[i];
            l=0;
            r=size-1;
            boolean flag = true;
            if(tempList.get(r)<v) {
                index = r;
                flag = false;
            } else if(tempList.get(r)==v) {
                index = r;
                flag = false;
            } else if(tempList.get(l)==v) {
                index  = l;
                flag = false;
            } else if(tempList.get(l)>v) {
                index  = l-1;
                flag = false;
            }
            while(l<=r && flag) {
                j = (l+r)/2;
                if(tempList.get(j)<v && v<tempList.get(j+1)) {
                    index = j;
                    break;
                } else if(tempList.get(j)<v && v<=tempList.get(j+1)){
                    index = j+1;
                    break;
                } else if(tempList.get(j)==v) {
                    index = j;
                    break;
                } else if(tempList.get(j)<v && v>tempList.get(j+1)) {
                    l = j+1;
                } else if(tempList.get(j)>v) {
                    r = j-1;
                }
            }
            System.out.println(size - index);
            res[i] = size - index;            
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice, aliceCount);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
