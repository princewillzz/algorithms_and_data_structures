import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SubsetSum {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for (String s : str)
            ar[index++] = Integer.parseInt(s);
        int val = Integer.parseInt(br.readLine().trim());

        System.out.println(solveRec(ar, val, ar.length)); // recursion
        Boolean memo[][] = new Boolean[ar.length + 1][val + 1];
        for (int i = 0; i < memo.length; i++)
            Arrays.fill(memo[i], null);
        System.out.println(solveMemo(ar, val, ar.length, memo));
        System.out.println(solveBottonUp(ar, val));

    }

    static boolean solveBottonUp(int ar[], int val) {
        if (val < 0 || ar.length <= 0)
            return false;
        boolean memo[][] = new boolean[ar.length + 1][val + 1];
        for (int i = 0; i < ar.length + 1; i++)
            memo[i][0] = true;

        for (int i = 1; i <= ar.length; i++) {
            for (int j = 1; j < val + 1; j++) {

                if (ar[i - 1] <= j) {
                    boolean include = memo[i - 1][j - ar[i - 1]];
                    boolean exclude = memo[i - 1][j];
                    memo[i][j] = include || exclude;
                } else {
                    memo[i][j] = memo[i - 1][j];
                }

            }

        }

        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                System.out.print(memo[i][j] + " ");
            }
            System.out.println();
        }

        return memo[ar.length][val];
    }

    static boolean solveMemo(int ar[], int val, int n, Boolean memo[][]) {
        if (val == 0)
            return true;
        if (val < 0 || n <= 0)
            return false;

        if (memo[n][val] != null)
            return memo[n][val];

        boolean include = solveMemo(ar, val - ar[n - 1], n - 1, memo);
        boolean exclude = solveMemo(ar, val, n - 1, memo);

        memo[n][val] = include || exclude;

        return memo[n][val];
    }

    static boolean solveRec(int ar[], int val, int n) {
        if (val == 0)
            return true;

        if (n <= 0)
            return false;

        return solveRec(ar, val, n - 1) || solveRec(ar, val - ar[n - 1], n - 1);

    }

}