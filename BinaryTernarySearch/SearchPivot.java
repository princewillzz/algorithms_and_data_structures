import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SearchPivot{
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for(String s: str) ar[index++] = Integer.parseInt(s);
        
        System.out.println(searchPivot(ar));
        
    }
    static int searchPivot(int ar[]) {
        int ans = Integer.MAX_VALUE, l = 0, r = ar.length-1;
        while(l <= r) {
            int mid = l+(r-l)/2;
            //System.out.println(ar[mid]+" "+ar[l]+" "+ar[r]);
            if(ar[mid] <= ar[l] && ar[mid] <= ar[r]) {
                ans = Math.min(ar[mid], ans);
                r = mid-1;
            }else if(ar[mid] > ar[l] && ar[mid] < ar[r]) {
                ans = Math.min(ar[mid], ans);
                r = mid-1;
            } 
            else {
                l = mid+1;
            }
        }
        if(ans == Integer.MAX_VALUE) ans = -1;
        return ans;
    }

}