import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonSubstring {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int max = solveBottomUp(s1, s1.length(), s2, s2.length());
        System.out.println(max);

        recSolve(s1, s1.length(), s2, s2.length(), new Integer[s1.length() + 1][s2.length() + 1]);
        System.out.println(maxLength);

    }

    static int maxLength = 0;

    static int recSolve(String s1, int n1, String s2, int n2, Integer[] memo[]) {
        if (n1 == 0 || n2 == 0)
            return 0;

        if (memo[n1][n2] != null)
            return memo[n1][n2];

        if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1)) {
            int a = recSolve(s1, n1 - 1, s2, n2 - 1, memo) + 1;
            maxLength = Math.max(maxLength, a);
            memo[n1][n2] = a;
            return a;
        }
        recSolve(s1, n1 - 1, s2, n2, memo);
        recSolve(s1, n1, s2, n2 - 1, memo);
        memo[n1][n2] = 0;
        return memo[n1][n2];
    }

    static int solveBottomUp(String s1, int n1, String s2, int n2) {
        int memo[][] = new int[n1 + 1][n2 + 1];

        int ans = 0, r = 0, c = 0;

        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                if (i == 0 || j == 0)
                    memo[i][j] = 0;
                else {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        memo[i][j] = memo[i - 1][j - 1] + 1;
                        // ans = Math.max(ans, memo[i][j]);
                        if (memo[i][j] > ans) {
                            ans = memo[i][j];
                            r = i;
                            c = j;
                        }
                    } else {
                        memo[i][j] = 0;
                    }
                }
            }
        }

        String s = s1.substring(r - ans, r);
        System.out.println(s);

        return ans;

    }
}