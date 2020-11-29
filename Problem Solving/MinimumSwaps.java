import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {

        Map<Integer, Integer> map = new HashMap();
        Map<Integer, Integer> value = new HashMap();
        for(int i=0;i<arr.length;i++) {
            map.put(arr[i],i);
            value.put(i, arr[i]);
        }        

        int c = 0;
        int pos = 0;
        int val = 0;

        for(int i=0;i<arr.length;i++) {
            if(map.get(i+1)==i) continue;

            pos = map.get(i+1);
            val = value.get(i);

            map.put(i+1, i);
            map.put(val, pos);

            value.put(i, i+1);
            value.put(pos, val);
            ++c;            
        }
        return c;
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

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
