import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class prims {

    public static void main(String[] args) throws InterruptedException {
        GenericWeightedGraph<Integer> graph = new GenericWeightedGraph<>();

        graph.addEdge(0, 1, true, 2);
        graph.addEdge(0, 3, true, 6);
        graph.addEdge(1, 3, true, 8);
        graph.addEdge(1, 2, true, 3);
        graph.addEdge(1, 4, true, 5);
        graph.addEdge(2, 4, true, 7);

        int msp = msp(graph, 0);
        System.out.println("Minimum spanning cost is: " + msp);

    }

    static int msp(GenericWeightedGraph<Integer> graph, int source) throws InterruptedException {

        int graphLength = 5;

        int keys[] = new int[5];
        Arrays.fill(keys, Integer.MAX_VALUE);
        keys[0] = 0;

        HashSet<Integer> msp = new HashSet<>();

        HashMap<Integer, Integer> parent = new HashMap<>();
        parent.put(0, -1);

        while (msp.size() < graphLength) {

            int smallest = Integer.MAX_VALUE;
            for (int i = 0; i < keys.length; i++) {
                if (!msp.contains(i) && (smallest == Integer.MAX_VALUE || keys[i] < keys[smallest])) {
                    smallest = i;
                }
                System.out.print(keys[i] + " ");
            }
            msp.add(smallest);

            Thread.sleep(1000);
            System.out.println(msp);

            // System.out.println(neighbours nbode
            for (Integer node : msp) {
                HashMap<Integer, Integer> neighbours = graph.adjList.get(node);
                for (Entry<Integer, Integer> pair : neighbours.entrySet()) {
                    if (!msp.contains(pair.getKey())) {

                        if (keys[pair.getKey()] > pair.getValue()) {
                            keys[pair.getKey()] = pair.getValue();
                            parent.put(pair.getKey(), smallest);
                        }
                    }
                }
            }

        }

        System.out.println(parent);

        int sum = 0;
        for (Entry<Integer, Integer> pair : parent.entrySet()) {
            int child = pair.getKey();
            int parnt = pair.getValue();

            if (parnt == -1)
                continue;

            var allchild = graph.adjList.get(parnt);

            sum += allchild.get(child);

        }

        return sum;
    }

}
