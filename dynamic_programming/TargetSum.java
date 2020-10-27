import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TargetSum {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for (String s : str)
            ar[index++] = Integer.parseInt(s);
        int val = Integer.parseInt(br.readLine().trim());

        System.out.println(solveBottomUp(ar, val));

    }

    static int solveBottomUp(int ar[], int target) {
        int sum = 0;
        for (int i : ar) {
            sum += i;
        }
        int val = (sum + target) / 2;
        if (val * 2 - target != sum)
            return 0;

        return subsetSumCount(ar, val);
    }

    static int subsetSumCount(int ar[], int val) {
        if (val < 0)
            return 0;
        int memo[][] = new int[ar.length + 1][val + 1];

        for (int i = 0; i <= ar.length; i++) {
            for (int j = 0; j <= val; j++) {
                if (j == 0) {
                    memo[i][j] = 1;
                } else if (i == 0) {
                    memo[i][j] = 0;
                } else {
                    if (ar[i - 1] <= j) {
                        memo[i][j] = memo[i - 1][j] + memo[i - 1][j - ar[i - 1]];
                    } else {
                        memo[i][j] = memo[i - 1][j];
                    }
                }
            }
        }

        return memo[ar.length][val];
    }

}