import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RodCutting {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for (String s : str)
            ar[index++] = Integer.parseInt(s);
        String sp[] = br.readLine().trim().split(" ");
        int price[] = new int[str.length];
        index = 0;
        for (String s : sp)
            price[index++] = Integer.parseInt(s);
        int val = Integer.parseInt(br.readLine().trim());

        System.out.println(solve(ar, price, ar.length, val, new int[ar.length + 1][val + 1]));
        System.out.println(solveBottomUp(ar, price, val));

    }

    static int solveBottomUp(int len[], int price[], int n) {
        if (n == 0)
            return 0;
        int memo[][] = new int[len.length + 1][n + 1];
        for (int i = 0; i <= len.length; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    memo[i][j] = 0;
                } else {
                    int include = Integer.MIN_VALUE, exclude = 0;
                    if (len[i - 1] <= j) {
                        include = price[i - 1] + memo[i][j - len[i - 1]];
                    }
                    exclude = memo[i - 1][j];
                    memo[i][j] = Math.max(include, exclude);
                }

            }
        }
        // for (int i = 0; i < memo.length; i++) {
        // for (int j = 0; j < memo[i].length; j++) {
        // System.out.print(memo[i][j] + " ");
        // }
        // System.out.println();
        // }
        return memo[len.length][n];
    }

    static int solve(int len[], int price[], int i, int n, int memo[][]) {

        if (n == 0 || i == 0)
            return 0;

        if (memo[i][n] != 0)
            return memo[i][n];

        int include = Integer.MIN_VALUE;
        if (len[i - 1] <= n)
            include = price[i - 1] + solve(len, price, i, n - len[i - 1], memo);
        int exclude = solve(len, price, i - 1, n, memo);
        memo[i][n] = Math.max(include, exclude);

        return memo[i][n];
    }

}