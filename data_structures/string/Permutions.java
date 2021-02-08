import java.util.*;
import java.io.*;

public class Permutions {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            String s = br.readLine();
            solve(new StringBuilder(s), new StringBuilder());

            List<String> l = new ArrayList<>();
            for (String c : hset) {
                l.add(c);
            }
            Collections.sort(l);
            for (String c : l) {
                System.out.print(c + " ");
            }
            System.out.println();

            hset.clear();
            l.clear();

        }

    }

    static HashSet<String> hset = new HashSet<>();

    static void solve(StringBuilder s, StringBuilder sb) {

        if (s.length() < 1) {
            hset.add(sb.toString());
            return;
        }

        for (int i = 0; i < s.length(); i++) {

            sb.append(s.charAt(i));
            StringBuilder temp = new StringBuilder(s.substring(0, i) + s.substring(i + 1, s.length()));
            solve(temp, sb);
            sb.deleteCharAt(sb.length() - 1);

        }

    }
}