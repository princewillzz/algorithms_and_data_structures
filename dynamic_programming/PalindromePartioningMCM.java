import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromePartioningMCM {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();

        Integer memo[][] = new Integer[str.length() + 1][str.length() + 1];
        System.out.println(solveMemo(str, 0, str.length() - 1, memo));
        // System.out.println(solveRec(str, 0, str.length() - 1));

    }

    static int solveMemo(String s, int start, int end, Integer memo[][]) {
        if (start >= end)
            return 0;

        if (memo[start][end] != null)
            return memo[start][end];

        if (isPalindrome(s, start, end)) {
            memo[start][end] = 0;
            return 0;
        }

        int result = Integer.MAX_VALUE;
        for (int k = start; k < end; k++) {
            int left = solveMemo(s, start, k, memo);
            int right = solveMemo(s, k + 1, end, memo);
            int temp = left + right + 1;
            result = Math.min(result, temp);
        }

        memo[start][end] = result;
        return result;

    }

    static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    static int solveRec(String str, int i, int j) {
        if (i >= j)
            return 0;

        if (isPalindrome(str, i, j))
            return 0;

        int result = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int left = solveRec(str, i, k);
            int right = solveRec(str, k + 1, j);
            int temp = left + right + 1;
            result = Math.min(result, temp);
        }

        return result;
    }

}