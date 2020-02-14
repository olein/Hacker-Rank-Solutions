import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makingAnagrams function below.
    static int makingAnagrams(String s1, String s2) {

        Map<Character, Integer> charMap = new HashMap<>();

        int lengthS1 = s1.length();
        for(int i = 0; i< lengthS1; i++) {
            char charValue = s1.charAt(i);
            if(charMap.containsKey(charValue)) {
                charMap.put(charValue,charMap.get(charValue) +1);
            } else {
                charMap.put(charValue,new Integer(1));
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

        for(int i = 0; i< lengthS1; i++) {
            char charValue = s1.charAt(i);
            if(Objects.nonNull(charMap.get(charValue)) && charMap.get(charValue)>0) {
                count = count + charMap.get(charValue);
                charMap.put(charValue,0);
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
