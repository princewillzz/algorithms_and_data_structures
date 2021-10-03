import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DjikstrasShortest {
    public static void main(String[] args) {

        GenericWeightedGraph<String> g = new GenericWeightedGraph<>();

        g.addEdge("Amritsar", "Jaipur", true, 4);
        g.addEdge("Amritsar", "Delhi", true, 1);
        g.addEdge("Jaipur", "Delhi", true, 2);
        g.addEdge("Jaipur", "Mumbai", true, 8);
        g.addEdge("Delhi", "Agra", true, 1);
        g.addEdge("Mumbai", "Bhopal", true, 3);
        g.addEdge("Bhopal", "Agra", true, 2);
        g.addEdge("NewYork", "London", true, 2000);

        g.printGraph();

        Scanner sc = new Scanner(System.in);

        String src = sc.next(), dest = sc.next();
        HashMap<String, Integer> cost = g.dijikstraShortestpath(src);

        System.out.println(cost);
        dijikstraShortestpath(g, src, dest);

    }

    static void dijikstraShortestpath(GenericWeightedGraph<String> graph, String source, String destination) {

        HashMap<String, Integer> dist = new HashMap<>();

        dist.put(source, 0);
        PriorityQueue<EntryK> minHeap = new PriorityQueue<>();

        for (var entry : graph.adjList.entrySet()) {

            if (entry.getKey().equals(source)) {
                minHeap.add(new EntryK(source, 0));
            } else
                minHeap.add(new EntryK(entry.getKey(), Integer.MAX_VALUE));

        }

        HashMap<String, String> parent = new HashMap<>();
        parent.put(source, null);

        while (!minHeap.isEmpty()) {
            var smallestEntry = minHeap.poll();
            var smallest = smallestEntry.getKey();
            var cost = smallestEntry.getValue();

            HashMap<String, Integer> neighbours = graph.adjList.get(smallest);
            // Relax all neighbours
            for (Entry<String, Integer> neighbour : neighbours.entrySet()) {
                if (cost != Integer.MAX_VALUE && (!dist.containsKey(neighbour.getKey())
                        || cost + neighbour.getValue() < dist.get(neighbour.getKey()))) {

                    dist.put(neighbour.getKey(), cost + neighbour.getValue());
                    minHeap.remove(new EntryK(neighbour.getKey(), 0));
                    minHeap.add(new EntryK(neighbour.getKey(), cost + neighbour.getValue()));
                    parent.put(neighbour.getKey(), smallest);
                }
            }

        }

        System.out.println(dist.get(destination));
        while (parent.containsKey(destination)) {
            System.out.print(destination + " <--");
            destination = parent.get(destination);
        }
        System.out.println();

    }

}

class EntryK implements Comparable<EntryK> {
    private String key;
    private int value;

    public EntryK(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {

        return this.getKey().equals(((EntryK) obj).getKey());
    }

    @Override
    public int compareTo(EntryK other) {
        return this.value - other.getValue();
    }

    @Override
    public String toString() {
        return "EntryK [key=" + key + ", value=" + value + "]";
    }
}
