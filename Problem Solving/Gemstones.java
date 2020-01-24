import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gemstones function below.
    static int gemstones(String[] arr) {
        Set<String> values = new HashSet();

        String s1 = arr[0];
        String c = "";
        int flag = 0;

        for(int j=0;j<s1.length();j++) {
            flag = 0;
            c = String.valueOf(s1.charAt(j));
            if(values.contains(c)) continue;
            for(int i=1;i<arr.length;i++) {
                if(arr[i].indexOf(c)==-1) {
                    flag = 1;
                    break;
                }
            }
            if(flag==0) values.add(c);
        }
        return values.size();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String arrItem = scanner.nextLine();
            arr[i] = arrItem;
        }

        int result = gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
