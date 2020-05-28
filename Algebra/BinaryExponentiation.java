import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryExponentiation {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Integer.parseInt(br.readLine().trim());
        int pow = Integer.parseInt(br.readLine().trim());

        long ans;
        ans = powr(num, pow);

        System.out.println(ans);
    }

    static long powr(long num, int pow) {
        // System.out.println(num + " " + pow);
        if (pow <= 0)
            return 1;

        int pas = pow / 2;
        long ans = powr(num * num, pas);

        int rem = pow % 2;
        if (rem != 0)
            return num * ans;
        return ans;
    }

    static long pow(long num, int pow) {
        long ans = 1;
        while (pow > 0) {
            int rem = pow % 2;

            if (rem != 0) {
                ans *= num;
            }
            num *= num;

            pow /= 2;
        }
        return ans;
    }

}