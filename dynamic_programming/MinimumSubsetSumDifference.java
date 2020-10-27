import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumSubsetSumDifference {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for (String s : str)
            ar[index++] = Integer.parseInt(s);

        System.out.println(solveBottomUp(ar));

    }

    static int solveBottomUp(int[] ar) {
        int sum = 0;
        for (int a : ar)
            sum += a;

        int val = sum / 2;

        int p1 = solveBottomUpHelper(ar, val);
        int p2 = sum - p1;
        return Math.abs(p1 - p2);
    }

    static int solveBottomUpHelper(int[] ar, int val) {
        if (val == 0)
            return 0;
        if (val < 0 || ar.length == 0)
            return 0;
        boolean memo[][] = new boolean[ar.length + 1][val + 1];

        for (int i = 0; i <= ar.length; i++) {
            for (int j = 0; j <= val; j++) {
                if (j == 0)
                    memo[i][j] = true;
                else if (i == 0)
                    memo[i][j] = false;
                else {
                    if (ar[i - 1] <= j) {
                        memo[i][j] = memo[i - 1][j] || memo[i - 1][j - ar[i - 1]];
                    } else {
                        memo[i][j] = memo[i - 1][j];
                    }
                }
            }
        }

        for (int i = val; i >= 0; i--) {
            if (memo[ar.length][i]) {
                return i;
            }
        }

        return 0;
    }

}