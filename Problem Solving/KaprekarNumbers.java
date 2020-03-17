import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class KaprekarNumbers{

    // Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(int p, int q) {
        int count = 0;    
        for(int i=p;i<=q;i++) {
            if(isKaprekar(i)) {
                System.out.print(i + " ");
                ++count;
            }
        }
        if(count==0) System.out.print("INVALID RANGE");
    }

    static boolean isKaprekar(long i){
        String s1 = String.valueOf(i);
        int d = s1.length();

        Long j = i*i;
        String s2 = String.valueOf(j);        

        Long sum = 0l;        
        
        if(s2.length()==1) sum = j;
        else sum = Long.parseLong(s2.substring(0,s2.length()-d)) + 
                Long.parseLong(s2.substring(s2.length()-d,s2.length()));
        
	if(sum==i) return true;
        else return false;
              
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}
