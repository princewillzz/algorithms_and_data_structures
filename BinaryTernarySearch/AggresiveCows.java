import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AggresiveCows{
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0)
        {   
            String inp[] = br.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            int ar[] = new int[n];
            for(int i = 0; i < n; i++) ar[i] = Integer.parseInt(br.readLine());
            Arrays.sort(ar);
            System.out.println(search(ar, k));
        }

    }
    static int search(int ar[], int k) {
        int ans = -1;
        int start=Integer.MAX_VALUE, end=Integer.MIN_VALUE;
        for(int i : ar) {end=Math.max(i, end); start = Math.min(i, start);}
        while(start <= end) {
            int mid = start + (end-start)/2;

            if(is_valid(ar, mid, k)) {
                ans = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }

        }

        return ans;
    }
    static boolean is_valid(int ar[], int diff, int cows) {
        int c = 1, prev = ar[0];
        for(int i = 1; i < ar.length; i++) {
            if(ar[i] >= prev+diff) {
                c++;
                prev = ar[i];
            }
            if(c == cows) return true;
        }
        if(c==cows) return true;
        return false;
    }

}