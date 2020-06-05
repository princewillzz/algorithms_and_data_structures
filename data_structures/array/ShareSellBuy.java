import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ShareSellBuy {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().trim().split(" ");
        int ar[] = new int[s.length];
        for (int i = 0; i < s.length; i++)
            ar[i] = Integer.parseInt(s[i]);

        System.out.println(MaxProfit(ar));

    }

    static public int MaxProfit(int prices[]) {
        if (prices.length < 1)
            return 0;

        int profits[][] = new int[3][prices.length];
        Arrays.fill(profits[0], 0);
        Arrays.fill(profits[1], 0);
        Arrays.fill(profits[2], 0);

        for (int k = 1; k < 3; k++) {
            int maxThusFar = Integer.MIN_VALUE;
            for (int d = 1; d < prices.length; d++) {
                maxThusFar = Math.max(maxThusFar, profits[k - 1][d - 1] - prices[d - 1]);
                profits[k][d] = Math.max(maxThusFar + prices[d], profits[k][d - 1]);

            }
        }
        return profits[2][prices.length - 1];
    }

}