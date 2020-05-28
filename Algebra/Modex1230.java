import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Modex1230 {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String str[] = br.readLine().split(" ");
            long x = Long.parseLong(str[0]);
            long y = Long.parseLong(str[1]);
            long n = Long.parseLong(str[2]);

            System.out.println(solve(x, y, n));
        }

    }

    static long solve(long x, long y, long n) {
        if (y == 0)
            return 1 % n;
        if (y == 1)
            return x;

        if (y % 2 == 0) {
            long ans = solve(x, y / 2, n);

            return ((ans % n) * (ans % n)) % n;
        } else {
            long ans = solve(x, y - 1, n);

            return ((ans % n) * (x % n)) % n;
        }

    }

}