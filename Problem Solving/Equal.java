import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the equal function below.
    static int equal(Integer[] arr) {
        
        List<Integer> values =  Arrays.asList(arr); 
        int min = Collections.min(values);
        //int max = Collections.max(values);
        //int fre = Collections.frequency(values, max);
        
        int c1 = count(arr.clone());

        System.out.println(c1);
        int add = 0;
        int count = 0;   
        for(int i=0;i<arr.length;i++) {            
            arr[i] = arr[i] - min;
        }          

        for(int i=0;i<arr.length;i++) {            
           while(arr[i]>0) {
            ++count;
            if(arr[i]>=5) arr[i] = arr[i] - 5;
            else if(arr[i]>=2 && arr[i]<5) arr[i] = arr[i] - 2;
            else arr[i] = arr[i] - 1;
           }
        } 
        System.out.println(count);
        return count<c1?count:c1;        
    }

    private static int count(Integer[] arr) {
        int count = 0;  
        for(int i=0;i<arr.length;i++) {            
           while(arr[i]>0) {
            ++count;
            if(arr[i]>=5) arr[i] = arr[i] - 5;
            else if(arr[i]>=2 && arr[i]<5) arr[i] = arr[i] - 2;
            else arr[i] = arr[i] - 1;
           }
        } 
        return count;
    }
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            Integer[] arr = new Integer[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int result = equal(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
