import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {

        int len = s.length();
        int count = 0;

        for(int i=1;i<=len-1;i++) {
            List<String> subStrList = new ArrayList();
            for(int j=0;j<=len-i;j++) {
                subStrList.add(s.substring(j,j+i));
                //System.out.println(s.substring(j,j+i));
            }
            //System.out.println(i + " " + subStrList.size());

            for(int j=0;j<subStrList.size()-1;j++) {
                for(int k=j+1;k<subStrList.size();k++) {
                    if(isAnagram(subStrList.get(j), subStrList.get(k))) ++count;
                }
            }
        }
        return count;
    }

    static boolean isAnagram(String a, String b) {        

        if(a.length()!=b.length()) return false;

        if(a.length()==0) return true;

        // String A = a.toUpperCase();
        // String B = b.toUpperCase();

        if(a.equals(b)) return true;

        char c = a.charAt(0);
        String s=Character.toString(c);
        
        a = a.replace(s,"");
        b = b.replace(s,"");

        return isAnagram(a,b);         
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
