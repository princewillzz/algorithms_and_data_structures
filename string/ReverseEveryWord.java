import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseEveryWord {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();
        char s[] = str.toCharArray();

        int start = 0, end = 0;
        for (int i = 0; i < s.length; i++) {
            if (i == s.length - 1 || s[i + 1] == ' ') {
                end = i;
                while (start < end) {
                    char c = s[start];
                    s[start] = s[end];
                    s[end] = c;
                    end--;
                    start++;
                }
                start = i + 2;
            }
        }
        StringBuilder ar = new StringBuilder(str);
        ar.append("harsh");
        System.out.println(ar);

        System.out.println(s);

    }

}