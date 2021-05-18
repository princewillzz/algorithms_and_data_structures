import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Bipartitite {

    public static void main(String[] args) {
        
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        graph.put(1, Arrays.asList(2));
        graph.put(2, Arrays.asList(1, 3, 8));
        graph.put(3, Arrays.asList(2, 4));
        graph.put(4, Arrays.asList(3, 5));
        graph.put(5, Arrays.asList(9, 6, 4));
        graph.put(6, Arrays.asList(5, 7));
        graph.put(7, Arrays.asList(6));
        graph.put(8, Arrays.asList(2, 9));
        graph.put(9, Arrays.asList(8, 5));

        
        boolean isGraphBipartite = isBipartitite(1, graph);

        if(isGraphBipartite) {
            System.out.println("Yes, Graph is Bipartite");
        } else {
            System.out.println("No, Graph is not Bipartite");
        }



    }

    static boolean isBipartitite(Integer startNode,
        HashMap<Integer, List<Integer>> graph
        ) {

        HashMap<Integer, Integer> isColored = new HashMap<>();

        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(startNode);

        int currentColor = 0;
        isColored.put(startNode, currentColor);


        boolean ans = true;

        while(!queue.isEmpty()) {
            int currentNode = queue.pollFirst();
            int currentNodeColor = isColored.get(currentNode);
            int toBeColoredWith = currentNodeColor == 0? 1: 0;

            List<Integer> neighbours = graph.get(currentNode);

            for (Integer neighbour : neighbours) {
                // If already coloured
                if(isColored.containsKey(neighbour)) {
                    int color = isColored.get(neighbour);
                    if(color == currentNodeColor) {
                        return false;
                    }
                } else {
                    queue.add(neighbour);
                    isColored.put(neighbour, toBeColoredWith);
                }
            }

        }

        // System.out.println(isColored);

        return ans;
    }
    
}
