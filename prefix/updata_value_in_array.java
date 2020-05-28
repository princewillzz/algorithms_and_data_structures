import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class updata_value_in_array {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int ar[] = new int[len];
        Arrays.fill(ar, 0);

        System.out.print("Test: ");
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            System.out.print("left to right: ");
            String str[] = br.readLine().trim().split(" ");
            int start = Integer.parseInt(str[0]), end = Integer.parseInt(str[1]);

            System.out.print("Increasing value: ");
            int value = Integer.parseInt(br.readLine().trim());

            if (start < 1 || end > len)
                continue;

            ar[start - 1] += value;
            if (end < len)
                ar[end] -= value;
        }

        for (int i = 1; i < len; i++) {
            ar[i] += ar[i - 1];
            System.out.print(ar[i - 1] + " ");
        }
        System.out.println(ar[len - 1]);

    }

}