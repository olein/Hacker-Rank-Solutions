import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {

        List<Character> characterList = convertStringToCharList(s1);
        Set<Character> characterSet = new HashSet<Character>(characterList);

        for(char c : characterSet) {            
            if(s2.indexOf(c)!=-1) return "YES";
        }
        return "NO";
    }

    public static List<Character> convertStringToCharList(String str) 
    {         
        List<Character> chars = new ArrayList<>(); 
  
        for (char ch : str.toCharArray()) { 
  
            chars.add(ch); 
        }  
        return chars; 
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
