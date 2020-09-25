import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the superDigit function below.
    static long superDigit(String n, int k) {
        
        String v = String.valueOf(n);

        long superDigit = 0;
        int sum = 0;
        for(int i=0;i<v.length();i++) {
            superDigit = superDigit + Character.getNumericValue(v.charAt(i));
        }
        //System.out.println("Super digit " + superDigit);

        superDigit = superDigit * k;

        //System.out.println("Super digit2 " + superDigit);

        while(String.valueOf(superDigit).length()>1) {
            String val = String.valueOf(superDigit);
            //System.out.println("val " + val);
            sum = 0;
            for(int i=0;i<val.length();i++) {
                sum = sum + Character.getNumericValue(val.charAt(i));
            } 
            superDigit = sum;
        }

        return superDigit;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        long result = superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
