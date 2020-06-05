import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class CountStringWithKRepeatation {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();
        int k = Integer.parseInt(br.readLine());

        System.out.println(solve(str, str.length(), k));

    }

    static boolean check(int a[], int k) {
        for (int i = 0; i < a.length; i++)
            if (a[i] != 0 && a[i] != k)
                return false;
        return true;
    }

    static int solve(String s, int len, int k) {
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int ar[] = new int[26];

            for (int j = i; j < len; j++) {

                int index = s.charAt(j) - 'a';
                ar[index]++;
                if (ar[index] > k)
                    break;
                if (ar[index] == k && check(ar, k))
                    ans++;
            }
        }
        return ans;
    }

}