import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnboundedCountOfSubset {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for (String s : str)
            ar[index++] = Integer.parseInt(s);
        int val = Integer.parseInt(br.readLine().trim());

        System.out.println(solveRec(ar, ar.length, val));

        System.out.println(solveMemo(ar, ar.length, val, new Boolean[ar.length + 1][val + 1]));

        System.out.println(solveBottomUp(ar, val));

    }

    static boolean solveBottomUp(int ar[], int target) {
        if (ar.length == 0 && target == 0) {
            return true;
        }
        if (target < 0 || ar.length == 0)
            return false;

        boolean[][] memo = new boolean[ar.length + 1][target + 1];
        for (int i = 0; i < ar.length + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                if (i == 0 || j == 0) {
                    if (i == 0)
                        memo[i][j] = true;
                } else {
                    if (ar[i - 1] <= j) {
                        memo[i][j] = memo[i][j - ar[i - 1]] || memo[i - 1][j];
                    } else {
                        memo[i][j] = memo[i - 1][j];
                    }
                }
            }
        }

        // for (int i = 0; i < memo.length; i++) {
        // for (int j = 0; j < memo[i].length; j++) {
        // System.out.print(memo[i][j] + " ");
        // }
        // System.out.println();
        // }

        return memo[ar.length][target];
    }

    static boolean solveRec(int ar[], int n, int target) {

        if (n == 0 && target == 0) {
            return true;
        }
        if (target < 0 || n == 0)
            return false;
        boolean exclude = solveRec(ar, n - 1, target);
        boolean include = solveRec(ar, n, target - ar[n - 1]);

        return exclude || include;
    }

    static boolean solveMemo(int ar[], int n, int target, Boolean memo[][]) {
        if (n == 0 && target == 0) {
            return true;
        }
        if (target < 0 || n == 0)
            return false;

        if (memo[n][target] != null)
            return memo[n][target];
        boolean include = false;
        if (target <= ar[n - 1])
            include = solveMemo(ar, n - 1, target, memo);
        boolean exclude = solveMemo(ar, n, target - ar[n - 1], memo);
        memo[n][target] = include || exclude;
        return include || exclude;
    }

}