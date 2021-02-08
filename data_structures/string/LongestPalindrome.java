
import java.io.*;

public class LongestPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        System.out.println(solve(s));

    }

    static String helper(String s, int i, int j) {

        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j))
                break;

            i--;
            j++;
        }

        return s.substring(i + 1, j);

    }

    static String solve(String s) {

        if (s.length() <= 1)
            return s;

        String max = new String();
        for (int i = 0; i < s.length() - 1; i++) {

            String t1 = helper(s, i, i);
            String t2 = helper(s, i, i + 1);

            if (t1.length() > max.length() || t2.length() > max.length()) {
                max = t1.length() > t2.length() ? t1 : t2;
            }

        }

        return max;

    }
}