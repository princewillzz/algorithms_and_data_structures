import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinChangeMaxWays {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for (String s : str)
            ar[index++] = Integer.parseInt(s);
        int val = Integer.parseInt(br.readLine().trim());

        System.out.println(solve(ar, ar.length, val));
        System.out.println(solveTopDown(ar, ar.length, val, new Integer[ar.length + 1][val + 1]));
        System.out.println(solveBottomUp(ar, val));

    }

    static int solveBottomUp(int coins[], int sum) {
        int memo[][] = new int[coins.length + 1][sum + 1];

        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                if (i == 0 || j == 0) {
                    if (j == 0)
                        memo[i][j] = 1;
                    else
                        memo[i][j] = 0;
                } else {
                    int include = 0, exclude = 0;
                    if (coins[i - 1] <= j) {
                        include = memo[i][j - coins[i - 1]];
                    }
                    exclude = memo[i - 1][j];
                    memo[i][j] = include + exclude;
                }
            }
        }
        return memo[coins.length][sum];
    }

    static int solveTopDown(int coins[], int n, int sum, Integer memo[][]) {
        if (sum == 0 && n == 0)
            return 1;
        if (sum < 0 || n == 0)
            return 0;

        if (memo[n][sum] != null)
            return memo[n][sum];

        memo[n][sum] = solveTopDown(coins, n - 1, sum, memo) + solveTopDown(coins, n, sum - coins[n - 1], memo);

        return memo[n][sum];

    }

    static int solve(int coins[], int n, int sum) {

        if (sum == 0 && n == 0) {
            return 1;
        }
        if (sum < 0 || n == 0) {
            return 0;
        }
        int include = solve(coins, n, sum - coins[n - 1]);
        int exclude = solve(coins, n - 1, sum);

        return include + exclude;
    }

}