import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountOfSubset {
    public static void main(String argv[]) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for (String s : str)
            ar[index++] = Integer.parseInt(s);
        int val = Integer.parseInt(br.readLine().trim());

        System.out.println(solveMemo(ar, ar.length, val, new Integer[ar.length + 1][val + 1]));
        System.out.println(solveBottomUp(ar, val));

    }

    static int solveMemo(int ar[], int n, int val, Integer memo[][]) {
        if (val == 0)
            return 1;
        if (n <= 0 || val < 0)
            return 0;
        if (memo[n][val] != null)
            return memo[n][val];

        if (ar[n - 1] <= val) {
            int include = solveMemo(ar, n - 1, val - ar[n - 1], memo);
            int exclude = solveMemo(ar, n - 1, val, memo);
            memo[n][val] = include + exclude;

        } else {
            int exclude = solveMemo(ar, n - 1, val, memo);
            memo[n][val] = exclude;
        }

        return memo[n][val];
    }

    static int solveBottomUp(int ar[], int val) throws InterruptedException {
        int count = 0;
        int memo[][] = new int[ar.length + 1][val + 1];

        for (int i = 0; i < ar.length + 1; i++) {
            for (int j = 0; j < val + 1; j++) {
                Thread.sleep(1000);

                if (i == 0 && j == 0)
                    memo[i][j] = 1;
                else if (j == 0)
                    memo[i][j] = 1;
                else if (i == 0)
                    memo[i][j] = 0;

                else {
                    if (ar[i - 1] <= j) {
                        int include = memo[i - 1][j - ar[i - 1]];
                        int exclude = memo[i - 1][j];
                        memo[i][j] = include + exclude;
                    } else {
                        int exclude = memo[i - 1][j];
                        memo[i][j] = exclude;
                    }
                }
                System.out.print(memo[i][j] + " ");
            }
            System.out.println();
        }

        return memo[ar.length][val];
    }

}