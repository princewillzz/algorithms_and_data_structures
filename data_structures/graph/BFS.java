import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS{
    public static void main(String argv[]) throws IOException {
        
        int ar[] = {0, 1, 2, 3, 4};
        ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
        alist.add(new ArrayList<>());
        alist.get(0).add(1);alist.get(0).add(3);
        alist.add(new ArrayList<>());
        alist.get(1).add(2);alist.get(1).add(3);//alist.get(0).add(4);

        alist.add(new ArrayList<>());
        alist.get(2).add(3);alist.get(2).add(1);alist.get(2).add(4);

        alist.add(new ArrayList<>());
        alist.get(3).add(0);alist.get(3).add(1);alist.get(3).add(4);

        alist.add(new ArrayList<>());
        //alist.get(4).add(2);
        
        System.out.println(bfs(0, ar, alist));

    }
    static int bfs(int start, int[] vertex, ArrayList<ArrayList<Integer>> edges) {
        int depth = 0, Target = 4;
        int visited[] = new int[vertex.length+1];
        LinkedList<Integer> q = new LinkedList<>();
        q.push(start);
        System.out.println(start);
        visited[start] = 1;
        while(!q.isEmpty()) {
            int curr = q.pop();
            boolean flag = false;
            ArrayList<Integer> childs = edges.get(curr);
            
            for(int i = 0; i < childs.size(); i++) {
                int edge = childs.get(i);
                
                if(visited[edge] != 1) {
                    flag = true;
                    q.push(edge);
                    visited[edge] = 1;
                    System.out.print(edge + " ");
                    if(edge == Target) {
                        System.out.println();
                        return ++depth;
                    }
                } 
            }
            if(flag) {System.out.println();depth++;}
        }
        return depth;
    }

}