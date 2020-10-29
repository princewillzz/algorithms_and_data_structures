import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubSets {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println("Subsets are :- ");
        solve(str, 0, "");
    }

    static void solve(String str, int i, String out) {
        if (str.length() == i) {
            System.out.println(out);
            return;
        }
        solve(str, i + 1, out);
        solve(str, i + 1, out + String.valueOf(str.charAt(i)));

    }
}