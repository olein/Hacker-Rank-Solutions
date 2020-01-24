import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong

        int l=0,lw=0,u=0,s=0,nu=0,count=0;

        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";

        for(int i=0;i<n;i++) {
            if(numbers.indexOf(password.charAt(i))!=-1) {
                nu = 1;
            } else if(lower_case.indexOf(password.charAt(i))!=-1) {
                lw = 1;
            } else if(upper_case.indexOf(password.charAt(i))!=-1) {
                u = 1;    
            } else if(special_characters.indexOf(password.charAt(i))!=-1) {
                s = 1;
            }
        }
        count = 4 - nu - lw - u - s;
        if(n<6) {
            return 6-n>count?6-n:count;
        } else return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
