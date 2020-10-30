import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestPalindromicSubsequence {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.println(solve(s));

    }

    static int solve(String s) {
        StringBuilder sb = new StringBuilder(s);
        // System.out.println(s);
        System.out.println(sb.reverse().toString());

        return LCS(s, sb.toString());
    }

    static int LCS(String s1, String s2) {
        int memo[][] = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                if (i == 0 || j == 0) {
                    memo[i][j] = 0;
                } else {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        memo[i][j] = memo[i - 1][j - 1] + 1;
                    } else {
                        memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                    }
                }
            }
        }

        StringBuilder st = new StringBuilder();

        int row = s1.length(), col = s2.length();

        while (row > 0 && col > 0) {
            if (s1.charAt(row - 1) == s2.charAt(col - 1)) {

                st.append(s1.charAt(row - 1));
                row--;
                col--;
            } else {
                if (memo[row - 1][col] > memo[row][col - 1]) {
                    row--;
                } else
                    col--;
            }
        }
        System.out.println(st.reverse());

        return memo[s1.length()][s2.length()];
    }

}