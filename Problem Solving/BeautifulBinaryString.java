import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BeautifulBinaryString{

    // Complete the beautifulBinaryString function below.
    static int beautifulBinaryString(String b) {
        String s = "010";
        int i = 0;
        int count = 0;
        while(b.contains(s)) {
            i = b.indexOf(s);
            b = replaceChar(b,i);
            //System.out.println(i + " " + b);
            ++count;
        }
        return count;
    }

    private static String replaceChar(String b, int i) {
        return b.substring(0,i+2)+'1'+b.substring(i+3,b.length());
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String b = scanner.nextLine();

        int result = beautifulBinaryString(b);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
