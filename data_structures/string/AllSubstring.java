import java.io.*;
import java.util.HashSet;

public class AllSubstring {

    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();

        generate(str, 0, new StringBuilder());
        System.out.println(hset);
        System.out.println(str);
        generate(str, str);

    }

    static void generate(String input, String output) {

        if (input.isBlank()) {
            System.out.print(output + " ");
            return;
        }

        generate(input.substring(1), output + input.charAt(0));

        generate(input.substring(1), output);
    }

    static HashSet<String> hset = new HashSet<>();

    static void generate(String s, int i, StringBuilder sb) {

        if (i == s.length()) {
            if (sb.length() > 0)
                hset.add(sb.toString());
            return;
        }

        generate(s, i + 1, sb);
        sb.append(s.charAt(i));
        generate(s, i + 1, sb);

        sb.deleteCharAt(sb.length() - 1);

    }
}
