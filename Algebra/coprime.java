import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class coprime {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int ans = solve(n);
            System.out.println(ans);
        }

    }

    static int solve(int n) {
        if (n == 1)
            return 1;
        int ans = 2;

        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (GCD(i, n / i) == 1) {
                    System.out.println(i + " " + n / i);
                    ans += 2;
                }
            }
        }

        return ans;
    }

    static int GCD(int a, int b) {
        return a % b == 0 ? b : GCD(b, a % b);
    }

}