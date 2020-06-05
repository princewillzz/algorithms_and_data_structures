import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AllSequence {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();

        char ch[] = new char[str.length() + 1];
        generate(str, str.length(), ch, 0, 0);

    }

    static void generate(String s, int l, char[] ar, int index, int curr) {
        if (curr >= l) {
            if (index > 0) {
                String str = String.copyValueOf(ar);
                if (checkPalin(str.substring(0, index), index))
                    System.out.println(str.substring(0, index));
            }
            return;
        }
        generate(s, l, ar, index, curr + 1);

        ar[index] = s.charAt(curr);
        generate(s, l, ar, index + 1, curr + 1);
    }

    static boolean checkPalin(String s, int l) {
        boolean ans = true;
        int i = 0, j = l - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                ans = false;
                break;
            }
            i++;
            j--;
        }
        return ans;
    }

}