import java.util.Scanner;

public class LinearDiophatine {
    public static void main(String argv[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        solve(a, b, c);
    }

    public static int xg = 0, yg = 0;

    static void solve(int a, int b, int c) {
        int g = gcd(a, b);
        if (c % g == 0) {
            System.out.println("No");
            return;
        }
        int x = xg;
        xg = x * (c / g);
        int y = yg;
        yg = y * (c / g);

        x = xg;
        y = yg;

        if (a < 0)
            x = -x;
        if (b < 0)
            y = -y;

        System.out.println(a + "*" + x + "+" + b + "*" + y + "=" + c);
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            xg = 1;
            yg = 0;
            return a;
        }
        int ans = gcd(b, a % b);
        int temp = xg;
        xg = yg;
        yg = temp - ((a / b) * xg);
        return ans;
    }
}