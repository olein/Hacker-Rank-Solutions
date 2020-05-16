import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the missingNumbers function below.
    static int[] missingNumbers(int[] arr, int[] brr) {
        Map<Integer, Integer> map=new HashMap();  
        int size = brr.length;
        for(int i=0;i<size;i++) {
            if(map.containsKey(brr[i])) {
                map.put(brr[i],map.get(brr[i])+1);
                //System.out.println(brr[i] + " " + map.get(brr[i]));
            } else {
                map.put(brr[i],1);
                //System.out.println(brr[i] + " " + map.get(brr[i]));
            }
        }
        int arrSize = arr.length;
        for(int i=0;i<arrSize;i++) {
            map.put(arr[i],map.get(arr[i])-1);
        }

        Set<Integer> set = new HashSet<Integer>(); 

        for(int i=0;i<size;i++) {
            //System.out.println(brr[i] + " " + map.get(brr[i]));
            if(map.get(brr[i])>0) {
                set.add(brr[i]);
            }
        }
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);
        
        int[] sortedArr = new int[set.size()];
        for(int i=0;i<sortedList.size();i++) {
            sortedArr[i] = sortedList.get(i);
        }

        return sortedArr;
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

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] brr = new int[m];

        String[] brrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrItems[i]);
            brr[i] = brrItem;
        }

        int[] result = missingNumbers(arr, brr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}