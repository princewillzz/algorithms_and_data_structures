import java.util.Scanner;

public class Permutaion {
    static int mod = (int) 1e9 + 7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), r = sc.nextInt();

        System.out.println(solve1(n, r));
        System.out.println(solve(n, r));
        System.out.println(solve2(n, r));
    }

    static int solve1(int n, int r) {

        // int memo[][] = new int[n + 1][r + 1];

        int nf = 1;
        for (int i = 2; i <= n; i++) {
            nf = ((nf % mod) * (i % mod)) % mod;
        }
        int nrf = 1;
        for (int i = 2; i <= (n - r); i++) {
            nrf = ((nrf % mod) * (i % mod)) % mod;
        }
        System.out.println(nf + " " + nrf);

        return nf / nrf;
        // return memo[n][r];
    }

    static int solve(int n, int r) {

        int memo[][] = new int[n + 1][r + 1];

        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                if (j > i)
                    memo[i][j] = 0;
                else if (i == 0 || j == 0)
                    memo[i][j] = 1;
                else {
                    memo[i][j] = ((((memo[i - 1][j - 1] % mod) * (j % mod)) % mod) + (memo[i - 1][j] % mod)) % mod;
                }
            }

        }

        return memo[n][r];
    }

    static int solve2(int n, int r) {

        int memo[] = new int[r + 1];

        memo[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = r; j > 0; j--) {
                // memo[j] = ((((memo[i - 1][j - 1] % mod) * (j % mod)) % mod) + (memo[i - 1][j]
                // % mod)) % mod;
                if (j > r)
                    memo[j] = 0;
                else {
                    memo[j] = ((((memo[j - 1] % mod) * (j % mod)) % mod) + (memo[j] % mod)) % mod;
                }
            }

        }

        return memo[r];
    }

}
