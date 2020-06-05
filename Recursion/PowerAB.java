import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PowerAB {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        long a = Long.parseLong(str[0]), b = Long.parseLong(str[1]);

        System.out.println(solve(a, b));

    }

    static long solve(long a, long b) {
        if (b <= 0)
            return 1;
        long ans = solve(a * a, b / 2);

        if (b % 2 == 0)
            return ans;

        return a * ans;

    }

}