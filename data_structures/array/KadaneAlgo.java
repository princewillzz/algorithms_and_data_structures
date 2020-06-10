import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KadaneAlgo {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for (String s : str)
            ar[index++] = Integer.parseInt(s);

        System.out.println(MaxSubArray(ar));

    }

    static int MaxSubArray(int ar[]) {
        int ans = ar[0], max = ar[0];
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] > ans + ar[i]) {
                ans = ar[i];
            } else {
                ans += ar[i];
            }
            max = Math.max(max, ans);

        }
        return max;
    }

}