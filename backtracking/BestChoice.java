import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BestChoice {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            int sum = Integer.parseInt(str[2]);

            int dp[][] = new int[n][m];

            System.out.println(solve(n, m, sum));
        }
    }

    static boolean solve(int n, int m, int sum) {

        if (sum == 0)
            return true;

        if (n == 0 || m == 0)
            return false;

        for (int i = 0; i <= m; i++) {
            if (solve(n - 1, m, sum - i))
                return true;
        }

        return false;

    }

}