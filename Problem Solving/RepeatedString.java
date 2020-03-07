import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RepeatedString{

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        int len = s.length();
        int[] pos = new int[len];
        int count = 0;
        long total = 0;
        for(int i=0;i<len;i++) {
            if(s.charAt(i) == 'a') {
                pos[count] = i;
                count++;
            }
        }

        total = (long) n/len;
        total = total*count;

        if(n%len==0) return total;

        long div = n%len;

        for(int i=0;i<count;i++) {
            if(pos[i]>(div-1)) return total;
            else ++total;
        }

        return total;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
