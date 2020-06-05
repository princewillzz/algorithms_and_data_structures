import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sort012 {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().trim().split(" ");
        int ar[] = new int[s.length];
        for (int i = 0; i < s.length; i++)
            ar[i] = Integer.parseInt(s[i]);

        sort(ar);

    }

    static void sort(int[] ar) {
        int start = 0, end = ar.length - 1;

        int mid = start;
        while (mid <= end) {
            if (ar[mid] == 0) {
                int t = ar[start];
                ar[start] = ar[mid];
                ar[mid] = t;
                mid++;
                start++;
            } else if (ar[mid] == 2) {
                int t = ar[end];
                ar[end] = ar[mid];
                ar[mid] = t;
                end--;
            } else {
                mid++;
            }
        }
        for (int ele : ar)
            System.out.print(ele + " ");

    }

}