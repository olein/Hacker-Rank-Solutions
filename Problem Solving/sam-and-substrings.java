import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the substrings function below.
    static BigInteger substrings(String str) {
        
        BigInteger sum = new BigInteger("0");
        BigInteger TEN = new BigInteger("10");
        //BigInteger NUM = new BigInteger("0");
        BigInteger modV = new BigInteger("1000000007");
        BigInteger prevSum = new BigInteger("0");
        BigInteger finalSum = new BigInteger("0");

        for (int i = 0; i < str.length(); i++) {           
            //NUM = BigInteger.valueOf(str.charAt(i)-'0');
            sum = BigInteger.valueOf(str.charAt(i)-'0')
            .multiply(BigInteger.valueOf(i+1))
            .add((prevSum.multiply(TEN)));
            //sum = sum.add((prevSum.multiply(TEN)));            
            finalSum = finalSum.add(sum);
            prevSum = sum;
            //System.out.println(sum + " " + prevSum + " " + finalSum);
        }
        finalSum = finalSum.mod(modV);    
        return finalSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String n = scanner.nextLine();

        BigInteger result = substrings(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
