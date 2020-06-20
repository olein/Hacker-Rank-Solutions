import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the luckBalance function below.
    static long luckBalance(int n, int k, int[][] contests) {
        long sum = 0;
        int count = 0;
        List<Integer> values = new ArrayList();
        for(int i=0;i<n;i++) {
            if(contests[i][1]==0) {
                sum+=contests[i][0];
                ++count;
            } else {
                values.add(contests[i][0]);
            }
        } 

        if(values.size()==0) return sum;      

        Collections.sort(values, Collections.reverseOrder());

        if(k>n-count) k = n - count;

        for(int i=0;i<k;i++) {
            sum = sum + values.get(i);
        }

        for(int i=k;i<n-count;i++) {
            sum = sum - values.get(i);
        }

        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        long result = luckBalance(n, k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
