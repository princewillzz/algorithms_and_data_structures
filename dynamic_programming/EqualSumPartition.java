import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EqualSumPartition {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for (String s : str)
            ar[index++] = Integer.parseInt(s);
        int val = 0;
        for (int a : ar)
            val += a;
        int p1 = val / 2;
        int p2 = p1;

        System.out.println(val + " " + p1 + " " + p2);

        // Bad solution
        System.out.println(solveRec(ar, ar.length, p1, p2));

        Boolean memo[][][] = new Boolean[ar.length + 1][p1 + 1][p2 + 1];
        // Bad Solution
        System.out.println(solveMemo(ar, ar.length, p1, p2, memo));

        // Better solution

    }

    static boolean solveBetter(int ar[]) {
        int val = 0;
        for (int n : ar)
            val += n;

        return val % 2 != 0 ? false : subsetSum(ar, ar.length, val / 2, new Boolean[ar.length + 1][val / 2 + 1]);
    }

    static boolean subsetSum(int ar[], int n, int target, Boolean memo[][]) {
        if (target == 0)
            return true;
        if (n <= 0 || target < 0)
            return false;
        if (memo[n][target] != null)
            return memo[n][target];
        memo[n][target] = subsetSum(ar, n - 1, target - ar[n - 1], memo) || subsetSum(ar, n - 1, target, memo);

        return memo[n][target];
    }

    static boolean solveMemo(int ar[], int n, int p1, int p2, Boolean memo[][][]) {
        if (p1 == 0 && p2 == 0 && n == 0)
            return true;
        if (p1 < 0 || p2 < 0)
            return false;
        if (n <= 0)
            return false;

        if (memo[n][p1][p2] != null)
            return memo[n][p1][p2];

        memo[n][p1][p2] = solveMemo(ar, n - 1, p1, p2 - ar[n - 1], memo)
                || solveMemo(ar, n - 1, p1 - ar[n - 1], p2, memo) || solveMemo(ar, n - 1, p1, p2, memo);

        return memo[n][p1][p2];
    }

    static boolean solveRec(int ar[], int n, int p1, int p2) {
        if (p1 == 0 && p2 == 0 && n == 0)
            return true;
        if (p1 < 0 || p2 < 0)
            return false;
        if (n <= 0)
            return false;
        // System.out.println(n);

        return solveRec(ar, n - 1, p1, p2) || solveRec(ar, n - 1, p1 - ar[n - 1], p2)
                || solveRec(ar, n - 1, p1, p2 - ar[n - 1]);
    }

}