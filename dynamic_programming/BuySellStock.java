import java.util.Scanner;

public class BuySellStock {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of days");
        int n = sc.nextInt();
        int prices[] = new int[n];

        System.out.println("Enter prices for each day: ");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        System.out.println("Enter number of transactions : ");
        int k = sc.nextInt();

        int maxProfit = solveBottomUp2(prices, k);
        System.out.println("Max Profits that can be made by " + k + " Transactions is : " + maxProfit);

        sc.close();

    }

    // 0(n^2)
    static int solveBottomUp2(int prices[], int k) {
        int n = prices.length;
        int profits[][] = new int[k + 1][n + 1];

        for (int t = 1; t < k + 1; t++) {
            int maxProfitOnPrevSell = Integer.MIN_VALUE;
            for (int d = 1; d < n + 1; d++) {

                maxProfitOnPrevSell = Math.max(maxProfitOnPrevSell, profits[t - 1][d - 1] - prices[d - 1]);

                int dontSell = profits[t][d - 1];
                int doSell = maxProfitOnPrevSell + prices[d - 1];

                profits[t][d] = Math.max(dontSell, doSell);
            }
        }

        return profits[k][n];
    }

    // 0(n^3)
    int solveBottomUp(int prices[], int k) {
        int n = prices.length;
        int profits[][] = new int[k + 1][n + 1];

        for (int t = 1; t < k + 1; t++) {
            for (int d = 1; d < n + 1; d++) {
                int dontSell = profits[t][d - 1];
                int doSell = Integer.MIN_VALUE;

                for (int x = 0; x < d; x++) {
                    int profitOnSellOnDayx = profits[t - 1][x] + prices[d - 1] - prices[x];
                    doSell = Math.max(doSell, profitOnSellOnDayx);
                }

                profits[t][d] = Math.max(dontSell, doSell);
            }
        }

        return profits[k][n];
    }

}
