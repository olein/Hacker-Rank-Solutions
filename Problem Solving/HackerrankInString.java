import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HackerrankInString{

    // Complete the hackerrankInString function below.
    static String hackerrankInString(String s) {
      String ms = "hackerrank";
      int mslen = ms.length();
      int len = s.length();
      int count = 0;
      for(int i=0;i<len;i++) {

        if(s.charAt(i) == ms.charAt(count)) {
            ++count;
            if(count == mslen) return "YES";
        }
      }
      return count==mslen?"YES":"NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = hackerrankInString(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
