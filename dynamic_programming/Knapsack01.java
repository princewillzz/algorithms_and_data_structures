import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

public class Knapsack01 {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for (String s : str)
            ar[index++] = Integer.parseInt(s);
        String wei[] = br.readLine().trim().split(" ");
        int weight[] = new int[str.length];
        index = 0;
        for (String s : wei)
            weight[index++] = Integer.parseInt(s);
        int w = Integer.parseInt(br.readLine());
        int memo[][] = new int[ar.length][w + 1];

        System.out.println(topDownDp(ar, weight, w, ar.length - 1, memo));

        System.out.println(bottomUp(ar, weight, w));

    }

    // Bottom up
    static int bottomUp(int profit[], int weight[], int capacity) {
        if (profit.length <= 0 || weight.length <= 0 || capacity <= 0)
            return 0;

        int n = profit.length;
        int memo[][] = new int[n + 1][capacity + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int c = 0; c < capacity + 1; c++) {

                if (c == 0 || i == 0) {
                    memo[i][c] = 0;
                } else {
                    if (weight[i - 1] <= c) {
                        int include = profit[i - 1] + memo[i - 1][c - weight[i - 1]];
                        int exclude = memo[i - 1][c];
                        memo[i][c] = Math.max(include, exclude);
                    } else {
                        memo[i][c] = memo[i - 1][c];
                    }
                }

            }
        }
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                System.out.print(memo[i][j] + " ");
            }
            System.out.println();
        }

        return memo[n][capacity];
    }

    // Top Down
    static int topDownDp(int profit[], int weight[], int capacity, int n, int memo[][]) {

        if (capacity <= 0 || n < 0)
            return 0;

        if (memo[n][capacity] != 0)
            return memo[n][capacity];

        if (weight[n] <= capacity) {
            int include = profit[n] + topDownDp(profit, weight, capacity - weight[n], n - 1, memo);
            int exclude = topDownDp(profit, weight, capacity, n - 1, memo);

            memo[n][capacity] = Math.max(include, exclude);

        } else {
            memo[n][capacity] = topDownDp(profit, weight, capacity, n - 1, memo);
        }

        return memo[n][capacity];
    }

}