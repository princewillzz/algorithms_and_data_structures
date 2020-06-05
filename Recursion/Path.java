import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Path {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int n = Integer.parseInt(str[0]), m = Integer.parseInt(str[1]);

        System.out.println(solve(n, m));

    }

    static int solve(int n, int m) {
        return helper(0, 0, n - 1, m - 1);
    }

    static int helper(int x1, int y1, int x2, int y2) {
        if (x1 == x2 && y1 == y2)
            return 1;
        if (x1 > x2 || y1 > y2)
            return 0;

        int path = 0;
        if (helper(x1 + 1, y1, x2, y2) >= 1)
            path++;
        if (helper(x1, y1 + 1, x2, y2) >= 1)
            path++;

        return path;

    }

}