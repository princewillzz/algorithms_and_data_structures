import java.util.Scanner;

public class Fibbonaci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long value1 = solve(n, new long[n + 1]);
        System.out.println("Recursion: " + value1);
        long value2 = solve2(n);
        System.out.println("Iteration: " + value2);
        System.out.println(value1 == value2);
        sc.close();
    }

    // Bottom up dp
    static long solve2(int n) {
        long memo[] = new long[n + 1];
        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n];
    }

    // memoize
    // It throws stackoverflow exception
    static long solve(int n, long memo[]) {

        if (n == 0 || n == 1)
            return n;

        if (memo[n] != 0)
            return memo[n];

        // System.out.println(n);
        memo[n] = solve(n - 1, memo) + solve(n - 2, memo);
        return memo[n];
    }
}
