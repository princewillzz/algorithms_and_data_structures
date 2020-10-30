import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestRepeatingSubsequence {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        StringBuilder s2 = new StringBuilder(s1);

        System.out.println(solve(s1, s2.toString()));

    }

    static int solve(String s1, String s2) {
        int memo[][] = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                if (i == 0 || j == 0)
                    memo[i][j] = 0;
                else {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1) && i != j) {
                        memo[i][j] = 1 + memo[i - 1][j - 1];
                    } else {
                        memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                    }
                }
                System.out.print(memo[i][j] + " ");
            }
            System.out.println();
        }

        int row = s1.length(), col = s2.length();
        StringBuilder sb = new StringBuilder();

        while (row > 0 && col > 0) {
            if (s1.charAt(row - 1) == s2.charAt(col - 1) && row != col) {
                sb.append(s1.charAt(row - 1));
                row--;
                col--;
            } else {
                if (memo[row - 1][col] >= memo[row][col - 1])
                    row--;
                else
                    col--;
            }
        }
        System.out.println(sb.reverse());
        return memo[s1.length()][s2.length()];
    }

}