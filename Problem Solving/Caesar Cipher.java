import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        String s = scan.next();
        int step = scan.nextInt();

        //step = step%26;

        for(int i = 0;i<n;i++) {
            if(Character.isLetter(s.charAt(i))) {
                if(Character.isUpperCase(s.charAt(i))) {
                    char r = (char) (65 + ((((int) s.charAt(i))-65) + (step%26))%26);
                    System.out.print(r);
                } else {
                    char r = (char) (97 + ((((int) s.charAt(i))-97)+ (step%26))%26 );
                    System.out.print(r);
                }    
            } else {
                System.out.print(s.charAt(i));
            }
        }
    }
}

