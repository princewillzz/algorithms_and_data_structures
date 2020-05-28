import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class modulor {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        long x = Long.parseLong(str[0]), b = Long.parseLong(str[1]), m = Long.parseLong(str[2]);

        System.out.println((solve(x, b, m)));

    }

    static long solve(long x, long b, long m) {
        if (b == 0)
            return 1;

        if (b % 2 == 0) {
            long ret = solve(x, b / 2, m);
            return (ret * ret) % m;
        } else {
            return ((x % m) * (solve(x, b - 1, m) % m)) % m;
        }

    }

}