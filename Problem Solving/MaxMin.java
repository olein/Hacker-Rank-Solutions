import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maxMin function below.
    static int maxMin(int n, int k, Integer[] c) {
        List<Integer> list = new ArrayList<>(Arrays.asList(c));
        Collections.sort(list);
        //System.out.println(Arrays.toString(list.toArray()));

        int size = 0;
        Integer diff = 0;
        Integer diff2 = 0;        

        for(int i=0;i<n-k+1;i++) {      
            if(i==0) 
                diff = list.get(i+k-1) - list.get(i);       
            else {
                diff2 = list.get(i+k-1) - list.get(i);
                if(diff>diff2) diff = diff2; 
            }  
        }
        return diff;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        int result = maxMin(n, k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
