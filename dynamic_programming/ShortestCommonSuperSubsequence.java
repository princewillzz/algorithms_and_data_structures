import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShortestCommonSuperSubsequence {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine().trim();
        String s2 = br.readLine().trim();

        System.out.println(solve(s1, s1.length(), s2, s2.length()));
        System.out.println(bottomUp(s1, s2));

    }

    static int bottomUp(String s1, String s2) {
        int memo[][] = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                if (i == 0 || j == 0) {
                    memo[i][j] = Math.max(i, j);
                } else {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        memo[i][j] = memo[i - 1][j - 1] + 1;
                    } else {
                        memo[i][j] = 1 + Math.min(memo[i - 1][j], memo[i][j - 1]);
                    }
                }
                // System.out.print(memo[i][j] + " ");
            }
            // System.out.println();
        }

        StringBuilder sb = new StringBuilder();
        int row = s1.length(), col = s2.length();
        while (row > 0 && col > 0) {
            if (s1.charAt(row - 1) == s2.charAt(col - 1)) {
                sb.append(s1.charAt(row - 1));
                row--;
                col--;
            } else {
                if (memo[row - 1][col] <= memo[row][col - 1]) {
                    sb.append(s1.charAt(row - 1));
                    row--;
                } else {
                    sb.append(s2.charAt(col - 1));
                    col--;
                }
            }
        }

        if (row == 0 && col != 0) {
            while (col > 0)
                sb.append(s2.charAt(--col));
        } else if (row != 0 && col == 0) {
            while (row > 0)
                sb.append(s1.charAt(--row));
        }

        System.out.println(sb.reverse());
        return memo[s1.length()][s2.length()];
    }

    static int solve(String s1, int n1, String s2, int n2) {
        if (n1 == 0 || n2 == 0)
            return Math.max(n1, n2);
        if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1)) {
            return 1 + solve(s1, n1 - 1, s2, n2 - 1);
        } else {
            return 1 + Math.min(solve(s1, n1 - 1, s2, n2), solve(s1, n1, s2, n2 - 1));
        }
    }

}