import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DuplicateInArray {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for (String s : str)
            ar[index++] = Integer.parseInt(s);

        search(ar);

    }

    /*
     * static void search(int ar[]) { for (int i = 0; i < ar.length; i++) { if
     * (ar[Math.abs(ar[i])] < 0) System.out.print(Math.abs(ar[i]) + " ");
     * ar[Math.abs(ar[i])] = -1 * ar[Math.abs(ar[i])]; } }
     */
    static void search(int ar[]) {
        int len = ar.length;
        for (int i = 0; i < len; i++) {
            ar[ar[i] % len] = ar[ar[i] % len] + len;
        }
        for (int i = 0; i < len; i++) {
            if (ar[i] >= 2 * len)
                System.out.print(i + " ");
        }
    }

}