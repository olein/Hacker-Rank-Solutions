import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the unboundedKnapsack function below.
    static int unboundedKnapsack(int k, int[] arr) {
        List<Integer> list = new ArrayList();
        for(int i=0;i<arr.length;i++) {
            if(k%arr[i]==0) return k;
            list.add(arr[i]);
        }
        int sum = k;
        int csum = k;

        //Collections.sort(list);

        for(int i=list.size()-1;i>=0;i--) {
            csum = k;
            for(int j=i;j>=0;) {                
                if(csum>=list.get(j)) {
                    csum = csum - list.get(j);     
                    for(int p=0;p<arr.length;p++) {
                        if(csum%arr[p]==0) return k;
                        list.add(arr[p]);
                    }               
                } else {
                    --j;
                }                
            }            
            if(csum<sum) sum = csum;
        }
        
        return k - sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        

        for (int l = 0; l < t; l++) {
            String[] nk = scanner.nextLine().split(" ");
            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int result = unboundedKnapsack(k, arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
