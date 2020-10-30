import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumNumberOfDeletionToMakePalindrome {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        StringBuilder sb = new StringBuilder(s1);

        System.out.println(s1.length() - solve(s1, sb.reverse().toString()));
        System.out.println(s1.length() - solve2(s1));
    }

    static int solve2(String s) {
        int n = s.length();
        int memo[][] = new int[n + 1][n + 1];

        for (int i = 1; i < memo.length; i++) {
            for (int j = 1; j < memo[i].length; j++) {
                if (s.charAt(i - 1) == s.charAt(n - j))
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                else
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);

            }
        }

        return memo[n][n];
    }

    static int solve(String s1, String s2) {
        int memo[][] = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                if (i == 0 || j == 0)
                    memo[i][j] = 0;
                else {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        memo[i][j] = 1 + memo[i - 1][j - 1];
                    } else {
                        memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                    }
                }
            }
        }

        return memo[s1.length()][s2.length()];
    }

}