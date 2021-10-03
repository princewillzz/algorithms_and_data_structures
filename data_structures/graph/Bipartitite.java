import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Bipartitite {

    public static void main(String[] args) throws IOException {

        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter no of nodes: ");
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter neighbours of " + i + " :");
            graph.put(i, Arrays.asList(br.readLine().split(" ")).stream().map(Integer::parseInt)
                    .collect(Collectors.toList()));
        }

        boolean isGraphBipartite = isBipartitite(1, graph);

        if (isGraphBipartite) {
            System.out.println("Yes, Graph is Bipartite");
        } else {
            System.out.println("No, Graph is not Bipartite");
        }

    }

    static boolean isBipartitite(Integer startNode, HashMap<Integer, List<Integer>> graph) {

        HashMap<Integer, Integer> isColored = new HashMap<>();

        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(startNode);

        int currentColor = 0;
        isColored.put(startNode, currentColor);

        boolean ans = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.pollFirst();
            int currentNodeColor = isColored.get(currentNode);
            int toBeColoredWith = currentNodeColor == 0 ? 1 : 0;

            List<Integer> neighbours = graph.get(currentNode);

            for (Integer neighbour : neighbours) {
                // If already coloured
                if (isColored.containsKey(neighbour)) {
                    int color = isColored.get(neighbour);
                    if (color == currentNodeColor) {
                        return false;
                    }
                } else {
                    queue.add(neighbour);
                    isColored.put(neighbour, toBeColoredWith);
                }
            }

        }

        // System.out.println(isColored);
        if (ans) {
            System.out.println(isColored);
        }

        return ans;
    }

}

/**
 * 2 4, 1 3, 2 4, 1 3
 */