import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ladder {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String str[] = br.readLine().trim().split(" ");
        // int ar[] = new int[str.length], index = 0;
        // for(String s: str) ar[index++] = Integer.parseInt(s);
        int val = Integer.parseInt(br.readLine().trim());

        int memo[] = new int[val + 1];
        System.out.println("top down: " + solve(val, memo));
        System.out.println("Bottom up: " + solve2(val));
        // System.out.println("Recursion: " + recSolve(val));

    }

    // bottom up
    static int solve2(int val) {
        if (val < 0)
            return 0;
        int memo[] = new int[val + 1];
        memo[0] = 1;
        if (val > 0)
            memo[1] = 1;
        if (val > 1)
            memo[2] = 2;
        if (val > 2)
            memo[3] = 4;

        for (int step = 4; step <= val; step++) {
            memo[step] = memo[step - 1] + memo[step - 2] + memo[step - 3];
        }

        return memo[val];
    }

    // Top down dp
    static int solve(int val, int memo[]) {

        if (val < 0)
            return 0;

        if (val == 0)
            return 1;

        if (memo[val] != 0)
            return memo[val];

        memo[val] = solve(val - 1, memo) + solve(val - 2, memo) + solve(val - 3, memo);
        return memo[val];
    }

    // recursion
    static int recSolve(int val) {
        if (val < 0)
            return 0;
        if (val == 0)
            return 1;

        return recSolve(val - 1) + recSolve(val - 2) + recSolve(val - 3);
    }

}