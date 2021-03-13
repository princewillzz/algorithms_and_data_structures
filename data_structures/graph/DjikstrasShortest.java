import java.util.HashMap;
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

        HashMap<String, Integer> cost = g.dijikstraShortestpath(sc.next());

        System.out.println(cost);

    }
}
