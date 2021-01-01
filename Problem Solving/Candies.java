import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    //9 9 8 7 7 6 6 5 4 3 -> 19
    //10 9 2 3 6 5 4 3 2 2 2 -> 22

    // Complete the candies function below.
    static long candies(int n, long[] arr) {
        int size = arr.length;
        int[] cand = new int[size];
        cand[0] = 1;

        for(int i = 1; i < size; i++)
        {
            if(arr[i] > arr[i-1])
            {
                cand[i] = cand[i-1]+1;
            } else {
                cand[i] = 1;
            }
        }
        
        for(int i = size-2; i >= 0; i--)
        {
            if(arr[i] > arr[i+1])
            {
                cand[i] = Math.max(cand[i], cand[i+1]+1);
            }        
        }

        int count = 0;
        for(int i = 0; i < size; i++)
        {
            count = count + cand[i];
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] arr = new long[n];

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
