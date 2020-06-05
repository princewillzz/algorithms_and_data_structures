import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestPalin {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();

        System.out.println(palin(str));

    }

    static int palin(String str) {
        int max = 0, n = str.length();
        for (int i = 0; i < n - 1; i++) {
            int curr = checkPalin(str, i, i);
            int curr1 = checkPalin(str, i, i + 1);
            curr = Math.max(curr, curr1);
            max = Math.max(curr, max);

        }
        return max;
    }

    static int checkPalin(String str, int i, int j) {

        int ans = 0;
        if (i == j) {
            ans = 1;
            i--;
            j++;
        }

        while (i > -1 && j < str.length() && str.charAt(i) == str.charAt(j)) {

            ans += 2;
            i--;
            j++;
        }
        return ans;
    }

}