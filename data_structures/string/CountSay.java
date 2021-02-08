import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountSay {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(solve(n));

    }

    static String solve(int n) {

        return helper(n, "");

    }

    static String helper(int n, String s) {

        if (n == 1) {
            return "1";
        }

        String temp = helper(n - 1, s);

        StringBuilder ans = new StringBuilder();

        int count = 1;
        char ch = temp.charAt(0);
        for (int i = 1; i < temp.length(); i++) {

            if (temp.charAt(i) == ch) {
                count++;
            } else {
                ans.append(count);
                ans.append(ch);

                count = 1;
                ch = temp.charAt(i);
            }

        }
        ans.append(count);
        ans.append(ch);

        return ans.toString();
    }
}
