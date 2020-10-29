import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AllBalancedParanthesis {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int val = Integer.parseInt(br.readLine().trim());

        solve(2 * val, "", val, val);
        for (String string : allCombinations) {
            System.out.println(string);
        }

    }

    static ArrayList<String> allCombinations = new ArrayList<>();

    static void solve(int val, String out, int open, int close) {

        if (val == 0) {
            allCombinations.add(out);
            // System.out.println(out);
            return;
        }

        if (close > open) {
            // Two choices
            if (open > 0)
                solve(val - 1, out + "(", open - 1, close);

            solve(val - 1, out + ")", open, close - 1);
        } else {

            solve(val - 1, out + "(", open - 1, close);
        }

    }

}