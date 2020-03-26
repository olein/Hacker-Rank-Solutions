import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BiggerIsGreater{

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        int len = w.length();
        String s = "";
        int[] data = new int[len];

        for(int i=0;i<len;i++) {
            data[i] = (int) w.charAt(i);
        }

        data = findNextPermutation(data);

        if(data.length == 1) return "no answer";

         for(int i=0;i<len;i++) {
             s = s + (char)data[i];
         }
         return s;
    }

    public static int[] findNextPermutation(int data[]) 
    { 
  
        if (data.length <= 1) 
            return new int[1]; 
  
        int last = data.length - 2; 
        while (last >= 0) { 
            if (data[last] < data[last + 1]) { 
                break; 
            } 
            last--; 
        } 
        if (last < 0) 
            return new int[1]; 
  
        int nextGreater = data.length - 1; 
  
        for (int i = data.length - 1; i > last; i--) { 
            if (data[i] > data[last]) { 
                nextGreater = i; 
                break; 
            } 
        } 
  
        data = swap(data, nextGreater, last); 
        data = reverse(data, last + 1, data.length - 1);  
        return data; 
    } 

    public static int[] swap(int data[], int left, int right) 
    { 
        int temp = data[left]; 
        data[left] = data[right]; 
        data[right] = temp; 
  
        return data; 
    } 
  
    public static int[] reverse(int data[], int left, int right) 
    { 
  
        while (left < right) { 
            int temp = data[left]; 
            data[left++] = data[right]; 
            data[right--] = temp; 
        } 
  
        return data; 
    }   
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
