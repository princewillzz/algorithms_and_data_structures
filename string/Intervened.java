import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Intervened {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        String b = br.readLine().trim();

        possible(s, b);

    }

    static void possible(String s, String b) {
        char ar[] = new char[s.length() + b.length() + 10];
        helper(s, b, ar, s.length(), b.length(), 0, 0, 0);
    }

    static void helper(String a, String b, char[] ar, int al, int bl, int i, int index1, int index2) {
        if (index1 >= al && index2 >= bl) {
            System.out.println(ar);
            return;
        }

        if (index1 < al) {
            ar[i] = a.charAt(index1);
            helper(a, b, ar, al, bl, i + 1, index1 + 1, index2);
        }
        if (index2 < bl) {
            ar[i] = b.charAt(index2);
            helper(a, b, ar, al, bl, i + 1, index1, index2 + 1);
        }
    }

}