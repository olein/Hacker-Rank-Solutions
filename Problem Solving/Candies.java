import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the candies function below.
    static long candies(int n, int[] arr) {
        long sum = 1;
        int last = 1;
        int[] count = new int[arr.length];
        count[0]=1;             

        for(int i=1;i<n;i++) {            
            if(arr[i]>arr[i-1]) {
                last = last+1;
                count[i] = last;
            } else {
                last = 1;
                count[i] = last;
            }
        }
        
        last = 1;
        count[n-1] = Math.max(1, count[n-1]);
        sum = count[n-1];
        for(int i=n-1;i>0;i--) {            
            if(arr[i-1]>arr[i]) {
                last = last+1;
                if(count[i-1]<last) count[i-1] = last;
            } else {
                last = 1;
                if(count[i]<last) count[i-1] = last;
            }
            sum = sum + count[i-1];
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
