import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS_Visit{
    public static void main(String argv[]) throws IOException {
        
        List<int[]> edges = new ArrayList<>();
        edges.add(new int[]{1, 2});
        edges.add(new int[]{3, 4});
        edges.add(new int[]{5, 6});
        edges.add(new int[]{0});
        edges.add(new int[]{0, 2});
        edges.add(new int[]{0,3});
        edges.add(new int[]{0, 3, 2, 1});
        edges.add(new int[]{7});
        byte[] visited = new byte[edges.size()+1];
        //visited[0] = 1;
        dfs(0, edges, visited);
        System.out.println();
    }
    static void dfs(int start, List<int[]> edges, byte[] visited) {
        visited[start] = 1;
        System.out.print(start+" ");
        int edge[] = edges.get(start);
        for(int i = 0; i < edge.length; i++) {
            if(visited[edge[i]] == 0) {
                //visited[edge[i]] = 1;
                dfs(edge[i], edges, visited);
            }
        }


    } 

}