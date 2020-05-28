import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExtendedEuclids {
    public static int x = 0, y = 0;

    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int a = Integer.parseInt(str[0]), b = Integer.parseInt(str[1]);

        System.out.println(solve(a, b));
        System.out.println(x + " " + y);

    }

    static int solve(int a, int b) {
        if (b == 0) {
            x = 1;
            y = 0;
            return a;
        }
        int ans = solve(b, a % b);
        int temp = x;
        x = y;
        y = temp - x * (a / b);
        return ans;
    }

}