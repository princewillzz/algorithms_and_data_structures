import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class version {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String version1[] = br.readLine().trim().split("\\.");
        String version2[] = br.readLine().trim().split("\\.");

        int n = Math.min(version1.length, version2.length);
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int v1 = Integer.parseInt(version1[i]);
            int v2 = Integer.parseInt(version2[i]);
            if (v1 > v2) {
                ans = 1;
                System.out.println(ans);
                return;
            } else if (v2 > v1) {
                ans = -1;
                System.out.println(ans);
                return;
            }
        }

        while (n < version1.length) {
            if (Integer.parseInt(version1[n]) > 0) {
                ans = 1;
                break;
            }
            n++;
        }
        while (n < version2.length) {
            if (Integer.parseInt(version1[n]) > 0) {
                ans = -1;
                break;
            }
            n++;
        }
        System.out.println(ans);

    }

}