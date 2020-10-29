import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TowerOfHanoi {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int val = Integer.parseInt(br.readLine().trim());

        solve(val, "source", "dest", "helper");
        System.out.println(count);

    }

    static int count = 0;

    static void solve(int n, String src, String dest, String helper) {
        count++;
        if (n == 1) {
            System.out.println("Moved disk 1 from " + src + " to " + dest);
            return;
        }

        solve(n - 1, src, helper, dest);
        System.out.println("Moved disk " + n + " from " + src + " to " + dest);

        solve(n - 1, helper, dest, src);

    }

}