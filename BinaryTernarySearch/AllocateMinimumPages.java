import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AllocateMinimumPages{
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for(String s: str) ar[index++] = Integer.parseInt(s);
        int val = Integer.parseInt(br.readLine().trim());
        
        System.out.println(solve(ar, val));

    }
    static int solve(int ar[], int k) {
        if(ar.length < k) return Integer.MIN_VALUE;
        int mini = -1;
        int start = ar[0], end = 0;
        for(int i: ar) {start = Math.max(i, start);end+=i;}
        
        while(start <= end) {
            
            int mid = start + (end-start)/2;
            if(isValid(ar, k, mid)) {
                mini = mid;
                end = mid-1;
            } else start = mid+1;
            
            // int curr = Integer.MIN_VALUE, i = 0, j = 0;
            // while(j++ < k) {
            //     int curr_sum = 0;
            //     while(i < ar.length && curr_sum+ar[i] <= mid) {
            //         curr_sum += ar[i++];
            //     }
            //     curr = Math.max(curr, curr_sum);
            //     if(j >= k && i < ar.length){
            //         start = mid+1;
            //     }
                
            // }
            // if(i >= ar.length) {mini = Math.min(mini, curr);end = mid-1;}
            
        } 

        return mini;
    }
    static boolean isValid(int ar[], int k, int max) {
        int j = 1, sum = 0;
        for(int i = 0; i < ar.length; i++) {
            sum += ar[i];
            if(sum > max) {
                j++;
                sum = ar[i];
            }
            if(j > k) return false;
        }
        if(j == k) return true;
        return false;
    }

}