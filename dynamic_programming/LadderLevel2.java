import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LadderLevel2 {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter n: ");
        int n = Integer.parseInt(br.readLine());
        System.out.print("Enter k: ");
        int k = Integer.parseInt(br.readLine());

        int memo[] = new int[n + 1];
        System.out.println(ways(n, k, memo));
        System.out.println(ways2(n, k));

    }

    // bottom up
    static int ways2(int n, int k) {
        if (n < 0)
            return 0;
        int memo[] = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        int index = 0;
        for (int i = 2; i <= n; i++) {

            // O(n) time complexity (Best way)
            memo[i] = (memo[i - 1] * 2);
            if (i > k)
                memo[i] -= memo[index++];

            // // Using this condition we can do it in O(n+k+1) time
            // if (i > k) {
            // // int sum = memo[i - 1] * 2;
            // // sum -= memo[i - k - 1];
            // // memo[i] = sum;
            // // System.out.println("Here");
            // // or
            // memo[i] = (memo[i - 1] * 2) - memo[index];
            // index++;
            // continue;
            // }

            // for (int j = 1; j <= k; j++) {
            // // System.out.println("Not here");
            // if (i - j < 0)
            // break;
            // memo[i] += memo[i - j];
            // }

        }

        return memo[n];
    }

    // Top down
    static int ways(int n, int k, int memo[]) {
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;

        if (memo[n] != 0)
            return memo[n];

        int res = 0;
        for (int i = 1; i <= k; i++) {
            res += ways(n - i, k, memo);
        }
        memo[n] = res;

        return memo[n];

    }

}