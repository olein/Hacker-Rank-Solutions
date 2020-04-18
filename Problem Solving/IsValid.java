import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        Map<String, Integer> mapVal = new HashMap();

        for(int i=0;i<s.length();i++){
            if(mapVal.containsKey(String.valueOf(s.charAt(i)))) {
                mapVal.put(String.valueOf(s.charAt(i)), 
                    mapVal.get(String.valueOf(s.charAt(i)))+1);
            } else {
                mapVal.put(String.valueOf(s.charAt(i)), 1);
            }            
        }

        int op = 0;
        Integer prev = 0;

        for (String key : mapVal.keySet()) {
            //System.out.println(key + " " + mapVal.get(key));
            if(prev == 0) prev = mapVal.get(key);
            else {
                if(op==0) {                    
                    if(mapVal.get(key)>1 && Math.abs(prev - mapVal.get(key))>1) 
                        return "NO";
                    else if(Math.abs(prev - mapVal.get(key))==1) ++op;
                    else if(mapVal.get(key)==1) ++op;
                } else if(op==1 && Math.abs(prev - mapVal.get(key))>=1){ 
                   return "NO"; 
                } 
            }
        }
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
