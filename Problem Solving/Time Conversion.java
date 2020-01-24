import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
      Scanner in = new Scanner(System.in);
        int a;

        int i = 0, j = 0;
        
        //a = in.nextInt();        
        String input = in.next();
        
        String am_pm = input.substring(8, 10);
        int hr = Integer.parseInt(input.substring(0, 2));
        String space = "";
        if(am_pm.equals("PM")) {            
            System.out.println((12+(hr%12))+input.substring(2,8));
        } else {
            if((hr%12) < 10) {
              space = "0";  
            }
            System.out.println(space + ((hr%12))+input.substring(2,8));
        }    
    }
}