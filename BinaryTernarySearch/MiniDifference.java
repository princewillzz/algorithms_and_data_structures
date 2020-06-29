import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MiniDifference{
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for(String s: str) ar[index++] = Integer.parseInt(s);
        int val = Integer.parseInt(br.readLine().trim());
        
        System.out.println(solve(ar, val));

    }
    static int solve(int ar[], int k) {
        int ans = Integer.MAX_VALUE;
        int l = 0, r = ar.length-1;
        while(l<=r) {
            int mid = l+(r-l)/2;
            //ans = Math.min(ans, Math.abs(ar[mid]-k));
            if(Math.abs(ans-k) > Math.abs(ar[mid]-k)) {
                ans = ar[mid];
            }
            if(k-ar[mid] >= 0) l = mid+1;
            else r = mid-1;
        }

        return ans;
    }

}