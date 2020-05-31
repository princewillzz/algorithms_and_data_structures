import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AllPalindromic {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();

        // generate(str, str.length());
        solve(str, str.length());

    }

    static void solve(String s, int l) {
        for (int i = 0; i < l; i++) {
            check(s, i, i, l);
            check(s, i, i + 1, l);
        }
    }

    static void check(String s, int left, int right, int len) {

        while (right < len && left > -1 && s.charAt(left) == s.charAt(right)) {

            right++;
            left--;
            System.out.println(s.substring(left + 1, right));
        }

    }

    static void generate(String s, int l) {

        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j <= l; j++) {
                if (checkPalin(s.substring(i, j), j - i - 1))
                    System.out.println(s.substring(i, j));
            }
        }
    }

    static boolean checkPalin(String s, int j) {
        boolean ans = true;
        int i = 0;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                ans = false;
                break;
            }
            i++;
            j--;
        }
        return ans;
    }

}