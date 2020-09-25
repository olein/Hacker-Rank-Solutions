import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the cost function below.
    static int cost(int[] B) {

        int s = 0;
        int n = B.length;
        int n1, n2;
        n1 = Math.abs(B[0] - 1);
        n2 = Math.abs(B[1] - 1);
        s = Math.max(n1,n2);
        if(n2<n1) B[1] = 1;
        for(int i=2;i<n;i++) {
            n1 = Math.abs(B[i-1] - 1);
            n2 = Math.abs(B[i-1] - B[i]);
            s = s + Math.max(n1,n2);
            if(n2<n1) B[i] = 1;
        }

        return s;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] B = new int[n];

            String[] BItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int BItem = Integer.parseInt(BItems[i]);
                B[i] = BItem;
            }

            int result = cost(B);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
