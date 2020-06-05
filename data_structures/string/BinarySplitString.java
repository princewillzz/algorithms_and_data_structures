import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySplitString {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();

        System.out.println(solve(str, str.length()));

    }

    static int solve(String s, int l) {

        int zero = 0, one = 0, ans = 0;
        for (int i = 0; i < l; i++) {
            if (s.charAt(i) == '0')
                zero++;
            else
                one++;
            if (zero == one)
                ans++;
        }
        if (zero != one)
            return -1;
        return ans;
    }

}