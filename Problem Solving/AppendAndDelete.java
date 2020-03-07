import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class AppendAndDelete{

    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
        int sl = s.length();

        int flag = 0;
        int count = 0;

        while(flag==0) {   
            ++count;             
            if(count>s.length()) break;     
            if(count>t.length()) break; 
                 
            if(!t.startsWith(s.substring(0,count))) {
                flag = 1;
            }            
        }       

        int delete = s.length()-count+1;
        int append = t.length() - count + 1;
        
        int diff = k - delete - append; 
        if(  diff>=0) {
            if(diff - ((s.length()-delete)*2)>0) return "Yes";
            else if(diff % 2 == 0) return "Yes";
            else return "No";
        }
        
        else return "No";     
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
