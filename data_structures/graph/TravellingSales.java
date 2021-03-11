public class TravellingSales {

    int n = 4;
    int dist[][] = { { 0, 20, 42, 25 }, { 20, 0, 30, 34 }, { 42, 30, 0, 10 }, { 25, 34, 10, 0 } };
    int visisted_all = (1 << n) - 1;

    int tsp(int mask, int current) {
        if (mask == visisted_all) {
            return dist[current][0];
        }

        int ans = Integer.MAX_VALUE;

        for (int city = 0; city < n; city++) {

            if (((1 << city) & mask) == 0) {
                int temp = tsp(mask | (1 << city), city) + dist[current][city];

                ans = Math.min(ans, temp);
            }

        }

        return ans;
    }

    public static void main(String[] args) {

        TravellingSales g = new TravellingSales();
        int t = g.tsp(1, 0);
        System.out.println(t);

        // GenericWeightedGraph<String> g = new GenericWeightedGraph<>();
        // g.addEdge("A", "B", true, 20);
        // g.addEdge("A", "C", true, 42);
        // g.addEdge("A", "D", true, 25);
        // g.addEdge("B", "D", true, 34);
        // g.addEdge("B", "C", true, 30);
        // g.addEdge("C", "D", true, 10);

        // g.printGraph();

    }
}
