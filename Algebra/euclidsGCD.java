import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class euclidsGCD {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str[] = br.readLine().trim().split(" ");
            int a = Integer.parseInt(str[0]), b = Integer.parseInt(str[1]);

            System.out.println(euclid(a, b));
        }

    }

    static int euclid(int a, int b) {
        return a % b == 0 ? b : euclid(b, a % b);
    }

}