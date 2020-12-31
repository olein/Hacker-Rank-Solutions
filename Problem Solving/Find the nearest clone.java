import java.io.;
import java.math.;
import java.security.;
import java.text.;
import java.util.;
import java.util.concurrent.;
import java.util.regex.;

public class Solution {

     Complete the findShortest function below.

    
      For the unweighted graph, name
     
      1. The number of nodes is nameNodes.
      2. The number of edges is nameEdges.
      3. An edge exists between nameFrom[i] to nameTo[i].
     
     
    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
         solve here
        
        int[][] adj = new int[graphNodes+1][graphNodes+1];
        
        for(int i=0;igraphFrom.length;i++) {
            adj[graphFrom[i]][graphTo[i]]=1;
            adj[graphTo[i]][graphFrom[i]]=1;
        }
        
        ListInteger nodes = new ArrayList();        
        
        for(int i=0;iids.length;i++) {
            if(ids[i]==val) nodes.add(i+1);
        }
        
        System.out.println(Node  + nodes);
        
        int min = graphFrom.length;
        
        
        for(int i  nodes) {
            boolean[] visited = new boolean[graphNodes+1];
            StackInteger stack = new StackInteger(); 
            int length = 0;
            for(int j=1;j=graphNodes;j++) {
                if(adj[i][j]==1) {
                    stack.push(j);                    
                }
            }
            System.out.println(stack);
            visited[i] = true;
            
            while(!stack.empty()) {
                Integer v = stack.pop();
                visited[v] = true;
                ++length;
                System.out.println(Node  + i +  leng  + length);
                int flag = 0;
                for(int j=1;j=graphNodes;j++) {
                    if(!visited[j] && adj[v][j]==1) {
                        stack.push(j); 
                        System.out.println(v +v+ Inside while   + stack);
                        if(ids[v-1]==val && v!=j) {
                            System.out.println(MIn   + min +  Leng  + length);
                            min = Math.min(min, length);     
                            flag =1;                       
                            break;    
                        }                        
                    }                    
                }
                if(flag==1) break;               
            }
        }
        return min==graphFrom.length-1min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv(OUTPUT_PATH)));

        String[] graphNodesEdges = scanner.nextLine().split( );
        int graphNodes = Integer.parseInt(graphNodesEdges[0].trim());
        int graphEdges = Integer.parseInt(graphNodesEdges[1].trim());

        int[] graphFrom = new int[graphEdges];
        int[] graphTo = new int[graphEdges];

        for (int i = 0; i  graphEdges; i++) {
            String[] graphFromTo = scanner.nextLine().split( );
            graphFrom[i] = Integer.parseInt(graphFromTo[0].trim());
            graphTo[i] = Integer.parseInt(graphFromTo[1].trim());
        }

        long[] ids = new long[graphNodes];

        String[] idsItems = scanner.nextLine().split( );
        scanner.skip((rn[nru2028u2029u0085]));

        for (int i = 0; i  graphNodes; i++) {
            long idsItem = Long.parseLong(idsItems[i]);
            ids[i] = idsItem;
        }

        int val = scanner.nextInt();
        scanner.skip((rn[nru2028u2029u0085]));

        int ans = findShortest(graphNodes, graphFrom, graphTo, ids, val);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
