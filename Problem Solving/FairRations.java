import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FairRations{

    // Complete the fairRations function below.
    static String fairRations(int[] B) {
        int count = 0;
        int odd = 0;
        for(int i=0;i<B.length;i++) {
            if(B[i]%2!=0) ++odd;
        }
        if(odd%2!=0) {            
            return "NO";
        }
        for(int i=0;i<B.length-1;i++) {
            if(B[i]%2==0) continue;

            B[i] = B[i] + 1;
            B[i+1] = B[i+1] + 1;
            count = count + 2;
        }

        return String.valueOf(count);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] B = new int[N];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < N; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        String result = fairRations(B);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
