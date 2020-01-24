import java.util.Scanner;

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        String[] values = new String[s.length()-2];

        for(int i=0;i<s.length()-2;i++) {
            String value = s.substring(i,i+3);
            values[i] = value;
        }

        java.util.Arrays.sort(values);
        smallest = values[0];
        largest = values[s.length()-3];
        
        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}