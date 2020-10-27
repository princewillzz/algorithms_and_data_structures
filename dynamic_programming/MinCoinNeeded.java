import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinCoinNeeded {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for (String s : str)
            ar[index++] = Integer.parseInt(s);

        Arrays.sort(ar);
        int val = Integer.parseInt(br.readLine().trim());

        System.out.println(solveAr(ar, val));
        //
        // System.out.println(solveRec(ar, val, new int[val + 1]));
        // System.out.println(solve(ar, val)); Recursion

    }

    // Bottom Up
    static int solveAr(int coins[], int sum) {
        if (sum <= 0)
            return 0;

        int memo[] = new int[sum + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;
        for (int i = 1; i < sum + 1; i++) {

            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    int smaller = memo[i - coins[j]];
                    if (smaller != Integer.MAX_VALUE) {
                        memo[i] = Math.min(smaller + 1, memo[i]);
                    }
                }

            }

        }

        return memo[sum];
    }

    // Top Down
    static int solveRec(int coins[], int sum, int memo[]) {
        if (sum <= 0)
            return 0;

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {

            if (coins[i] <= sum) {
                int smaller = 0;
                if (memo[sum - coins[i]] != 0) {
                    smaller = memo[sum - coins[i]];
                } else {
                    smaller = solveRec(coins, sum - coins[i], memo);

                }
                if (smaller != Integer.MAX_VALUE)
                    ans = Math.min(smaller + 1, ans);

            }

            // if (sum - coins[i] < 0)
            // continue;
            // int choosingCurrentCoin = 0;
            // if (memo[i][sum] != 0)
            // choosingCurrentCoin = memo[i][sum];
            // else {
            // choosingCurrentCoin = solveRec(coins, sum - coins[i], memo);
            // memo[i][sum] = choosingCurrentCoin;
            // }
            // ans = Math.min(choosingCurrentCoin + 1, ans);
        }

        memo[sum] = ans;
        return ans;
    }

    // Recursion
    static int solve(int coins[], int sum) {
        if (sum <= 0)
            return 0;

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (sum - coins[i] < 0)
                continue;
            ans = Math.min(solve(coins, sum - coins[i]) + 1, ans);
        }

        return ans;
    }

}