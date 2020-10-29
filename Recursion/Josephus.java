import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Josephus {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int k = Integer.parseInt(br.readLine());

        ArrayList<Integer> circle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            circle.add(i + 1);
        }

        System.out.println(solve(circle, 0, n, k));

    }

    static int solve(ArrayList<Integer> circle, int index, int n, int k) {
        if (n == 1) {
            System.out.println(circle);
            return circle.get(0);
        }

        int pos = index + k - 1;
        if (pos >= circle.size()) {
            pos = (pos) % (circle.size());

        }

        System.out.println(circle);
        circle.remove(pos);

        return solve(circle, pos, n - 1, k);
    }

}