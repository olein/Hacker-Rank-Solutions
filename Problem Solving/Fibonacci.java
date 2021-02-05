import java.util.*;

public class Solution {

    public static int fibonacci(int n) {
        int a = 0;
        int b = 1;
        int temp = a;
        
        if(n==1) return b;
        
        for(int i=2;i<=n;i++) {
            temp = b;
            b = b + a;
            a =  temp;            
        }
        return b;

        // Complete the function.
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}