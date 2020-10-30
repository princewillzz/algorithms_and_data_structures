import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonSubsequence {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();
        String str2 = br.readLine().trim();

        System.out.println(
                solve(str, str.length(), str2, str2.length(), new Integer[str.length() + 1][str2.length() + 1]));

        System.out.println(bottomUp(str, str2));

    }

    static String string = new String();

    static int bottomUp(String s1, String s2) {
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
        String s = "";
        StringBuilder st = new StringBuilder();

        int row = s1.length(), col = s2.length();

        while (row > 0 && col > 0) {
            if (s1.charAt(row - 1) == s2.charAt(col - 1)) {
                s = s1.charAt(row - 1) + s;
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

        System.out.println(s);
        System.out.println(st.reverse());

        return memo[s1.length()][s2.length()];
    }

    static int solve(String s1, int n1, String s2, int n2, Integer memo[][]) {
        if (n1 == 0 || n2 == 0)
            return 0;

        if (memo[n1][n2] != null)
            return memo[n1][n2];

        if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1)) {
            memo[n1][n2] = solve(s1, n1 - 1, s2, n2 - 1, memo) + 1;
        } else {
            memo[n1][n2] = Math.max(solve(s1, n1 - 1, s2, n2, memo), solve(s1, n1, s2, n2 - 1, memo));
        }
        return memo[n1][n2];

    }

}