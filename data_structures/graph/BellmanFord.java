import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Map.Entry;

/**
 * BellmanFord
 */
public class BellmanFord {

    public static void main(String[] args) {
        GenericWeightedGraph<String> graph = new GenericWeightedGraph<>();

        graph.addEdge("s", "y", false, 7);
        graph.addEdge("s", "t", false, 6);

        graph.addEdge("y", "z", false, 9);
        graph.addEdge("y", "x", false, -3);

        graph.addEdge("z", "s", false, 2);
        graph.addEdge("z", "x", false, 7);

        graph.addEdge("x", "t", false, -2);

        graph.addEdge("t", "x", false, 5);
        graph.addEdge("t", "y", false, 8);
        graph.addEdge("t", "z", false, -4);

        bellmanFord(graph, "s", "x");

    }

    static void bellmanFord(GenericWeightedGraph<String> graph, String src, String dest) {
        int verticesLength = graph.adjList.size();

        // Distance of each
        HashMap<String, Integer> dist = new HashMap<>();
        dist.put(src, 0);

        HashMap<String, String> parent = new HashMap<>();
        parent.put(src, null);

        for (int i = 0; i < verticesLength; i++) {
            HashSet<String> visited = new HashSet<>();
            visited.add(src);

            LinkedList<String> queue = new LinkedList<>();
            queue.push(src);

            while (!queue.isEmpty()) {
                String current = queue.pollFirst();
                HashMap<String, Integer> neighbours = graph.adjList.get(current);

                for (Entry<String, Integer> entry : neighbours.entrySet()) {
                    String currentparent = current;
                    String currentDestination = entry.getKey();
                    int cost = entry.getValue();

                    // relax
                    if (dist.containsKey(currentparent) && (!dist.containsKey(currentDestination)
                            || dist.get(currentDestination) > dist.get(currentparent) + cost)) {
                        dist.put(currentDestination, dist.get(currentparent) + cost);
                        parent.put(currentDestination, currentparent);

                    }

                    if (!visited.contains(currentDestination))
                        queue.addLast(currentDestination);

                }
            }

        }

        System.out.println(dist);
        System.out.println(parent);

        System.out.println("PATH ==== ");
        while (dest != null) {
            System.out.print(dest + " <--- ");
            dest = parent.get(dest);
        }
        System.out.println();

    }
}