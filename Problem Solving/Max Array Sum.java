import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {

        int len = arr.length;
        int sum = 0;
        int max = 0;
        int prevmax= 0;        
       
        int[] contsum = new int[len];
        
        for(int i=0;i<len/2+1;i++) {            
            Arrays.fill(contsum,0);
            max = arr[i];
            prevmax = 0;
            for(int j=i+1;j<len;j++) {
               contsum[j] = prevmax + arr[j];
               if(max>prevmax) prevmax = max;
               max = contsum[j];  
            }
            max = prevmax>max?prevmax:max;
            sum = max>sum?max:sum;
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
