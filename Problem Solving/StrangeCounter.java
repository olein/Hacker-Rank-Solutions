import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class StrangeCounter{

    // Complete the strangeCounter function below.
    static long strangeCounter(long t) {

        long counter = 3;
        long counterPos = 3;


        for(int i=0;;i++){
            if(t<=counterPos) {
                return counterPos - t + 1;
            } else if(counterPos<t) {                
                counterPos = counterPos + (long)(6 * Math.pow(2,i));
            } 
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long t = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = strangeCounter(t);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
