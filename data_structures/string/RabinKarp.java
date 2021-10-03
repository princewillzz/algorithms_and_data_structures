import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * RabinKarp
 */
public class RabinKarp {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine().trim();
        String pattern = br.readLine().trim();

        int digits = 10, mod = (int) 1e9 + 7;

        int phash = 0, thash = 0;
        // patterns hash
        for (int i = 0; i < pattern.length(); i++) {
            phash += pattern.charAt(i) * Math.pow(digits, pattern.length() - i - 1);
            thash += text.charAt(i) * Math.pow(digits, pattern.length() - i - 1);
        }
        int pn = pattern.length();

        if (thash == phash && pattern.equals(text.substring(0, pn)))
            System.out.print(0);

        // roller
        for (int i = pn; i < text.length(); i++) {
            thash = thash - (int) (text.charAt(i - pn) * Math.pow(digits, pn - 1));
            thash *= digits;
            thash += text.charAt(i);

            if (thash == phash)
                System.out.println(text.substring(i - pn + 1, i + 1));
            if (thash == phash && pattern.equals(text.substring(i - pn + 1, i))) {
                // System.out.println(phash + " " + thash + " " + (i - pn) + " " +
                // text.charAt(i));
                System.out.print(" " + (i - pn + 1));
            }
        }

        System.out.println();

    }
}