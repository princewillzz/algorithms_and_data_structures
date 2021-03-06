import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MCM {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for (String s : str)
            ar[index++] = Integer.parseInt(s);
        // int val = Integer.parseInt(br.readLine().trim());

        System.out.println(solveRec(ar, 1, ar.length - 1));
        System.out.println(solveMemo(ar, 1, ar.length - 1, new Integer[ar.length + 1][ar.length + 1]));
        // System.out.println(solveBottomUp(ar));

    }

    

    static int solveMemo(int ar[], int i, int j, Integer memo[][]) {
        if (i >= j)
            return 0;
        if (memo[i][j] != null)
            return memo[i][j];

        int res = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int left = solveMemo(ar, i, k, memo);
            int right = solveMemo(ar, k + 1, j, memo);
            int tempAns = (ar[i - 1] * ar[k] * ar[j]) + left + right;
            res = Math.min(res, tempAns);
        }

        memo[i][j] = res;
        return res;

    }

    static int solveRec(int ar[], int i, int j) {
        if (i >= j)
            return 0;

        int res = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int left = solveRec(ar, i, k);
            int right = solveRec(ar, k + 1, j);
            int tempAns = (ar[i - 1] * ar[k] * ar[j]) + left + right;
            res = Math.min(res, tempAns);
        }

        return res;

    }

}