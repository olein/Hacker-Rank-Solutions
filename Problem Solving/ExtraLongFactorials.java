import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.math.BigInteger; 

public class ExtraLongFactorials{

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {

        BigInteger r = new BigInteger("1");
        for(int i=2;i<=n;i++) {
            r = r.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.println(r);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}
