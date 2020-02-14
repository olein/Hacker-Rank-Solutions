import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the funnyString function below.
    static String funnyString(String s) {
        StringBuffer sb = new StringBuffer(s);
        StringBuffer sbr = new StringBuffer(s);
        sbr.reverse();

        StringBuffer diff = new StringBuffer("");
        StringBuffer diff2 = new StringBuffer("");

        for (int i = 1; i < sb.length(); i++) {
            diff.append(Math.abs(sb.charAt(i) - sb.charAt(i - 1)));
        }

        for (int i = 1; i < sbr.length(); i++) {
            diff2.append(Math.abs(sbr.charAt(i) - sbr.charAt(i - 1)));
        }

        if (diff.toString().equals(diff2.toString())) return "Funny";

        return "Not Funny";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = funnyString(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
