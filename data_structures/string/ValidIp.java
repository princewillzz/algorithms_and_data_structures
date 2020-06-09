import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ValidIp {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        ArrayList<String> ar = solve(s);
        for (String a : ar) {
            System.out.print(a + " ");
        }

    }

    static ArrayList<String> solve(String s) {
        ArrayList<String> ans = new ArrayList<>();

        String s1 = "", s2 = "", s3 = "", s4 = "";
        for (int i = 0; i < s.length(); i++) {
            if (s1.length() < 3 && s1.charAt(s1.length() - 1) != 0) {
                s1 += String.valueOf(s.charAt(i));
            } else if (s2.length() < 3 && s1.charAt(s1.length() - 1) != 0) {
                s2 += String.valueOf(s.charAt(i));
            } else if (s3.length() < 3 && s1.charAt(s1.length() - 1) != 0) {
                s3 += String.valueOf(s.charAt(i));
            } else if (s4.length() < 3 && s1.charAt(s1.length() - 1) != 0) {
                s4 += String.valueOf(s.charAt(i));
            } else {
                s1 = "";
                s2 = "";
                s3 = "";
                s4 = "";
                break;
            }
        }
        s1 += s2 + s3 + s4;
        if (s1.length() != s.length())
            return new ArrayList<>();

        return ans;
    }

}