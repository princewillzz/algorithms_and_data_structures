import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GCDOfRange {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().trim().split(" ");
        int ar[] = new int[s.length];
        for (int i = 0; i < s.length; i++)
            ar[i] = Integer.parseInt(s[i]);

        System.out.println(GCD(ar, 0, 3));

    }

    static int GCD(int ar[], int start, int end) {
        int small = ar[start];
        for (int i = start + 1; i <= end; i++) {
            if (ar[i] < small)
                small = ar[i];
        }
        int ans = 1;
        for (int i = small; i > 0; i--) {
            boolean flag = true;
            for (int k = start; k <= end; k++) {
                if (ar[k] % i != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans = i;
                break;
            }
        }

        return ans;
    }

}