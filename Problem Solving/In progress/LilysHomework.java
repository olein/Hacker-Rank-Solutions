import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the lilysHomework function below.
    static int lilysHomework(int[] arr, int n) {

        Map<Integer, Integer> val = new HashMap();
        Map<Integer, Integer> val2 = new HashMap();

        for(int i=0;i<n;i++) {
            val.put(arr[i], i);
            val2.put(arr[i], i);
        }

        int count1 = 0;
        int count2 = 0;
        int teamp = 0;

        int[] sortArr = Arrays.copyOfRange(arr, 0, n);

        Arrays.sort(sortArr);

        for(int i=0;i<n;i++) {
            if(val.get(sortArr[i]) != i) {
                teamp = val.get(sortArr[i]);
                val.put(arr[i], teamp);
                val.put(sortArr[i], i);

                ++count1;
            }
        }

        int[] revSortArr = new int[n];

        for(int i=0;i<n;i++) {
            revSortArr[i] = sortArr[Math.abs(i-(n-1))];
        }

        for(int i=0;i<n;i++) {
            if(val2.get(revSortArr[i]) != i) {
                teamp = val2.get(revSortArr[i]);
                val2.put(arr[i], teamp);
                val2.put(revSortArr[i], i);
                ++count2;
            }
        }

        return count1>count2?count2:count1;
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

        int result = lilysHomework(arr,n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
