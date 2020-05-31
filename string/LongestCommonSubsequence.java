import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine().trim(), s2 = br.readLine().trim();
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        int ans = longestSequence(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length(), dp);
        System.out.println(ans);

        int index = dp[s1.length()][s2.length()];
        int r = s1.length(), c = s2.length();
        char ch[] = new char[index--];
        while (r > 0 && c > 0) {
            if (s1.charAt(r - 1) == s2.charAt(c - 1)) {
                ch[index] = s1.charAt(r - 1);
                r--;
                c--;
                index--;
            } else if (dp[r - 1][c] > dp[r][c - 1])
                r--;
            else
                c--;
        }
        System.out.println(ch);
        System.out.print(" ");
        for (int i = 0; i < s2.length(); i++)
            System.out.print("  " + s2.charAt(i));
        System.out.println();
        int count = 0;
        for (int i = 1; i < s1.length() + 1; i++) {
            if (count < s1.length())
                System.out.print(s1.charAt(count++) + " ");
            for (int j = 1; j < s2.length() + 1; j++) {
                if (dp[i][j] >= 0)
                    System.out.print(' ');
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();

        }

    }

    static int longestSequence(char[] s1, char[] s2, int l1, int l2, int[][] dp) {
        if (dp[l1][l2] != -1)
            return dp[l1][l2];
        if (l1 == 0 || l2 == 0) {
            dp[l1][l2] = 0;
            return dp[l1][l2];
        }

        if (s1[l1 - 1] == s2[l2 - 1]) {
            dp[l1][l2] = 1 + longestSequence(s1, s2, l1 - 1, l2 - 1, dp);

        } else {
            dp[l1 - 1][l2] = longestSequence(s1, s2, l1 - 1, l2, dp);
            dp[l1][l2 - 1] = longestSequence(s1, s2, l1, l2 - 1, dp);
            dp[l1][l2] = Math.max(dp[l1 - 1][l2], dp[l1][l2 - 1]);
        }
        return dp[l1][l2];

    }

}