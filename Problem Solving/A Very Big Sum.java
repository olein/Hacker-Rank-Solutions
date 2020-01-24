import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int a;
        long sum = 0;
        int[] b = new int[11];
        int i = 0, j = 0, k = 0;

        a = in.nextInt();

        for (i = 0; i < a; i++) {
            sum = sum + in.nextInt();
        }

        System.out.println(sum);
    }
}