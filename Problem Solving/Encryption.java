import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Encryption{

    // Complete the encryption function below.
    static String encryption(String s) {
        s = s.replace(" ","");
        String res = "";
        int len = s.length();
        double sqr = Math.sqrt(len);
        int row = (int) Math.floor(sqr);
        int col = (int) Math.ceil(sqr);
        int pos = 0;
        for(int i=0;i<col;i++) {
            for(int j=0;j<col;j++) {
                pos = i+(j*col);
                if(pos<len) res = res + s.charAt(pos);
            }
            res = res + " ";
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
