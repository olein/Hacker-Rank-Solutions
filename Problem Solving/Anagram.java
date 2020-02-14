import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the anagram function below.
    static int anagram(String s) {
        if(s.length()%2!=0) {
            return -1;
        }

        String s1 = s.substring(0,s.length()/2);
        String s2 = s.substring(s.length()/2,s.length());

        Map<Character, Integer> charMap = new HashMap<>();

        int lengthS1 = s1.length();
        for(int i = 0; i< lengthS1; i++) {
            char charValue = s1.charAt(i);
            if(charMap.containsKey(charValue)) {
                charMap.put(charValue,charMap.get(charValue) +1);
            } else {
                charMap.put(charValue,1);
            }
        }

        int count = 0;

        int lengthS2 = s2.length();
        for(int i = 0; i< lengthS2; i++) {
            char charValue = s2.charAt(i);
            if(charMap.containsKey(charValue)) {
                if(Objects.nonNull(charMap.get(charValue)) && charMap.get(charValue)>0) {
                    charMap.put(charValue,charMap.get(charValue)-1);
                } else ++count;
            } else ++count;
        }

        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = anagram(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
