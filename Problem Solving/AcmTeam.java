import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class AcmTeam{

    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {
        int[] res = new int[2];
        int max = 0;
        int maxInt = 0;
        int count = 0;

        int topics = topic[0].length();
        int perticipant = topic.length;

        for(int i=0;i<perticipant-1;i++) {
            for(int j=i+1;j<perticipant;j++) {
                maxInt = 0;
                for(int k=0;k<topics;k++) {
                    if(topic[i].charAt(k) == '1' || topic[j].charAt(k) == '1') {
                        ++maxInt;
                    }
                }
                if(max<maxInt) {
                    max = maxInt;
                    count = 1;
                } else if(max == maxInt) {
                    ++count;
                }
            }
        }

        res[0] = max;
        res[1] = count;
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
