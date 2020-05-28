import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BigMod374 {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long b = Long.parseLong(br.readLine());
        long p = Long.parseLong(br.readLine());
        long m = Long.parseLong(br.readLine());

        System.out.println(solve(b, p, m));

    }

    static long solve(long b, long p, long m) {
        if (p == 0) {
            return 1 % m;
        }

        if (p % 2 == 0) {
            long y = solve(b, p / 2, m) % m;
            return (y * y) % m;
        } else {
            long y = solve(b, p - 1, m) % m;
            return (y * (b % m)) % m;
        }
    }

}