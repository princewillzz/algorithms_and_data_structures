import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubsetWithSpaces {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();

        solve(str, 0, "");
        System.out.println();
        CaptitalLize(str, 0, "");

    }

    static void CaptitalLize(String str, int index, String out) {
        if (index == str.length()) {
            System.out.println(out);
            return;
        }
        CaptitalLize(str, index + 1, out + String.valueOf(str.charAt(index)).toUpperCase());
        CaptitalLize(str, index + 1, out + str.charAt(index));
    }

    static void solve(String str, int index, String output) {

        if (index == str.length() - 1) {
            System.out.println(output + str.charAt(index));
            return;
        }
        solve(str, index + 1, output + (str.charAt(index) + " "));
        solve(str, index + 1, output + (str.charAt(index) + ""));

    }

}