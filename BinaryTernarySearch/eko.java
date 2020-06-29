import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class eko{
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inp[] = br.readLine().split(" ");
        int n = Integer.parseInt(inp[0]);
        long cut = Long.parseLong(inp[1]);
        String str[] = br.readLine().trim().split(" ");
        long ar[] = new long[n];int index = 0;
        for(String s: str) ar[index++] = Long.parseLong(s);
        
        
        System.out.println(solve(ar, cut));

    }
    static long solve(long ar[], long cut) {
        long ans = 0;
        long start = 1, end = (long)Integer.MIN_VALUE;
        for(long i: ar) end = Math.max(i, end);

        while(start <= end) {
            long mid = start + (end-start)/2;

            int x = is_valid(ar, cut, mid);
            if(x == 0) {
                return mid;
            } else if(x == 1) {
                ans = mid;
                start = mid+1;
            }
            else {
                end = mid-1;
            }

        }

        return ans;
    }
    static int is_valid(long ar[], long required, long height) {
        // System.out.println();
        // System.out.println(height);
        long sum = 0;
        for(int i = 0; i < ar.length; i++) {
            long leftOver = ar[i]-height;
            if(leftOver > 0) sum+=leftOver;
            //System.out.print(sum+" ");
            if(sum > required) return 1;
        }
        if(sum == required) return 0;
        return -1;
    }

}