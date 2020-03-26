import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TimeInWords {

    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {

        

        if(m==0) return ones[h] + " o' clock";
        if(m==15) return "quarter past " +ones[h];
        if(m==30) return "half past " +ones[h];
        if(m==45) return "quarter to " +ones[h+1];
        if(m==1) {
            return ones[m]+ " minute past " +ones[h];            
        }
        if(m>1 && m<30) {
            if(m<20) {
                return ones[m]+ " minutes past " +ones[h];
            } else {
                return tens[m  / 10] + ((m % 10 != 0) ? " " : "") + ones[m % 10] + 
                " minutes past " +ones[h];
            }
        }
        
        if(m>30 && m<59) {
            if(60-m<20) {
                return ones[60-m]+ " minutes to " +ones[h+1];
            } else {
                return tens[(60-m)   / 10] + (((60-m)  % 10 != 0) ? " " : "") + 
                ones[(60-m)  % 10]+ " minutes to " +ones[h+1];
            }
        }            
        return "";
    }

public static String[] ones = { 
  "", "one", "two", "three", "four", 
  "five", "six", "seven", "eight", 
  "nine", "ten", "eleven", "twelve", 
  "thirteen", "fourteen", "fifteen", 
  "sixteen", "seventeen", "eighteen", 
  "nineteen"
};
 
public static String[] tens = {
  "",          // 0
  "",          // 1
  "twenty",    // 2
  "thirty",    // 3
  "forty",     // 4
  "fifty",     // 5
  "sixty",     // 6
  "seventy",   // 7
  "eighty",    // 8
  "ninety"     // 9
};

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
