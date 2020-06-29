import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RowColumnSortedArray{
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ar[][] = {
            {1, 4, 6},
            {3, 0, 0}
        };
        int val = Integer.parseInt(br.readLine().trim());
        
        System.out.println(solve(ar, val));

    }
    static String solve(int ar[][], int val) {
        
        int r = 0, c = ar[0].length-1;
        while(c >= 0 && r < ar.length) {
            if(ar[r][c] == val) return (r+1)+" "+(c+1);

            if(ar[r][c] > val) c--;
            else r++;

        }
        return "-1";
    }

}