import java.io.*;

public class LongestRepeat {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        System.out.println(solve(s));
    }

    static String solve(String s) {
        int memo[][] = new int[s.length() + 1][s.length() + 1];

        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                if (i == 0 || j == 0)
                    memo[i][j] = 0;
                else {
                    if (s.charAt(i - 1) == s.charAt(j - 1) && i != j) {
                        memo[i][j] = 1 + memo[i - 1][j - 1];
                    } else {
                        memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                    }
                }
            }
        }

        int row = s.length(), col = s.length();
        StringBuilder sb = new StringBuilder();

        while (row > 0 && col > 0) {
            if (s.charAt(row - 1) == s.charAt(col - 1) && row != col) {
                sb.append(s.charAt(row - 1));
                row--;
                col--;
            } else {
                if (memo[row - 1][col] >= memo[row][col - 1])
                    row--;
                else
                    col--;
            }
        }

        return sb.reverse().toString();
    }
}
