import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// input- String with T, F, &, |, ^
// output- int  : no of ways to make expression to true

public class BooleanParenthesisMCM {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.println(solve(s, 0, s.length(), true));
        System.out.println(solveMemo(s, 0, s.length(), true, new Integer[s.length() + 1][s.length() + 1][2]));

    }

    static int solveMemo(String s, int i, int j, boolean evaluateTo, Integer memo[][][]) {
        if (i > j)
            return 0;
        if (i == j) {
            if (s.charAt(i) == 'T' && evaluateTo)
                return 1;
            if (s.charAt(i) == 'F' && !evaluateTo)
                return 1;
            return 0;
        }

        if (memo[i][j][evaluateTo ? 1 : 0] != null)
            return memo[i][j][evaluateTo ? 1 : 0];

        int ans = 0;

        for (int k = i + 1; k < j; k += 2) {
            int leftt = solve(s, i, k - 1, true);
            int leftf = solve(s, i, k - 1, false);
            int rightt = solve(s, k + 1, j, true);
            int rightf = solve(s, k + 1, j, false);
            int temp;

            if (s.charAt(k) == '^') {
                if (evaluateTo)
                    temp = leftt * rightf + leftf * rightt;
                else
                    temp = leftf * rightf + leftt * rightt;

            } else if (s.charAt(k) == '|') {
                if (evaluateTo)
                    temp = leftt * rightt + leftt * rightf + leftf * rightt;
                else
                    temp = leftf + rightf;
            } else {
                if (!evaluateTo)
                    temp = leftt * rightt + leftt * rightf + leftf * rightt;
                else
                    temp = leftf * rightf;
            }

            ans = Math.max(temp, ans);

        }

        memo[i][j][evaluateTo ? 1 : 0] = ans;

        return memo[i][j][evaluateTo ? 1 : 0];
    }

    static int solve(String s, int i, int j, boolean evaluateTo) {
        if (i > j)
            return 0;
        if (i == j) {
            if (s.charAt(i) == 'T' && evaluateTo)
                return 1;
            if (s.charAt(i) == 'F' && !evaluateTo)
                return 1;
            return 0;
        }

        int ans = 0;
        for (int k = i + 1; k < j; k += 2) {
            int temp = 0;

            int leftt = solve(s, i, k - 1, true);
            int rightt = solve(s, k + 1, j, true);
            int leftf = solve(s, i, k - 1, false);
            int rightf = solve(s, k + 1, j, false);

            if (s.charAt(k) == '^') {
                if (evaluateTo)
                    temp = Math.max(leftt + rightf, leftf + rightt);
                else
                    temp = Math.max(leftf + rightf, leftt + rightt);

            }
            ans = Math.max(temp, ans);
            if (s.charAt(k) == '|') {
                if (evaluateTo)
                    temp = Math.max(Math.max(leftt + rightt, leftt + rightf), leftf + rightt);
                else
                    temp = leftf + rightf;
            }
            if (s.charAt(k) == '&') {
                if (!evaluateTo)
                    temp = Math.max(Math.max(leftt + rightt, leftt + rightf), leftf + rightt);
                else
                    temp = leftf + rightf;
            }

            ans = Math.max(temp, ans);

        }

        return ans;
    }

}