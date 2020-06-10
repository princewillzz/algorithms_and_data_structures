import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MergeIntervals {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ar[][] = new int[][] { { 1, 4 }, { 0, 5 } };

        int ans[][] = merge(ar);
        // Arrays.sort(ar);
        for (int[] a : ans)
            System.out.printf("[%d,%d]\n", a[0], a[1]);

    }

    static int[][] merge(int ar[][]) {
        ArrayList<Integer[]> alist = new ArrayList<Integer[]>();
        int a[] = new int[2];
        a[0] = ar[0][0];
        a[1] = ar[0][1];
        for (int i = 1; i < ar.length; i++) {
            if (a[1] >= ar[i][0]) {
                a[1] = Math.max(a[1], ar[i][1]);
                if (a[0] > ar[i][0])
                    a[0] = ar[i][0];
            } else {
                alist.add(new Integer[] { a[0], a[1] });
                a[0] = ar[i][0];
                a[1] = ar[i][1];
            }
        }
        alist.add(new Integer[] { a[0], a[1] });

        int ans[][] = new int[alist.size()][2], index = 0;
        for (Integer ele[] : alist) {
            ans[index][0] = ele[0];
            ans[index++][1] = ele[1];
        }

        return ans;
    }

}