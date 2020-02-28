import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the alternate function below.
    static int alternate(String s) {
    Set<Character> charMap = new HashSet<>();
    int length = 0;
    int lengthS1 = s.length();
      for(int i = 0; i< lengthS1; i++) {
          char charValue = s.charAt(i);
          charMap.add(charValue);          
      }      

      for(int i=0;i<charMap.size()-1;i++) {
        String s2 = s.replaceAll(String.valueOf(charMap.toArray()[i]),"");
        for(int j=i+1;j<charMap.size();j++) {
          s2 = s2.replaceAll(String.valueOf(charMap.toArray()[j]),"");          
          if(isAlternatig(s2)) {            
            if(length<s2.length()) length = s2.length();
          }
        }
      }
      return length;

    }

    public static boolean isAlternatig(String s2){

    if(s2.length()<=2) return false;
    
    for(int i=0;i<s2.length()-2;i++) {
      if(s2.charAt(i)==s2.charAt(i+2) && s2.charAt(i)!=s2.charAt(i+1)) {

      } else {
        return false;
      }
    }
    return true;
  }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
