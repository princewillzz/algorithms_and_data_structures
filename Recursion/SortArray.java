import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortArray {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for (String s : str)
            ar[index++] = Integer.parseInt(s);

        solve(ar);

    }

    static void solve(int ar[]) {

        sortRec(ar, ar.length);

        for (int i : ar) {
            System.out.print(i + " ");
        }
    }

    static void sortRec(int ar[], int end) {
        if (end <= 1)
            return;

        sortRec(ar, end - 1);
        swapRec(ar, ar.length - 1, ar[end - 1]);

    }

    static void swapRec(int ar[], int n, int item) {
        if (n <= 0) {
            ar[0] = item;
            return;
        }

        if (item < ar[n - 1]) {

            swapRec(ar, n - 1, item);

        }

    }

    // Bubble SOrt
    static void helperBubble(int ar[], int n) {
        if (n <= 1)
            return;

        for (int i = 0; i < ar.length - 1; i++) {
            if (ar[i] > ar[i + 1]) {
                int temp = ar[i];
                ar[i] = ar[i + 1];
                ar[i + 1] = temp;
            }
        }
        helperBubble(ar, n - 1);

    }

}