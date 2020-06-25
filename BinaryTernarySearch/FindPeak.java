import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindPeak{
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for(String s: str) ar[index++] = Integer.parseInt(s);
        
        System.out.println(findPeak(ar));
        
    }
    static int findPeak(int ar[]) {
        int ans = -1, l = 0, r = ar.length-1;
        while(l <= r) {
            int mid = l+(r-l)/2;
            if(mid-1 < 0 && mid+1 > ar.length-1) return ar[mid];
            else if(mid-1 < 0) {
                return ar[mid] < ar[mid+1]? ar[mid+1]: ar[mid];
            } else if(mid+1 > ar.length-1) {
                return ar[mid-1] > ar[mid]? ar[mid-1]: ar[mid];
            }
            if(ar[mid] > ar[mid-1] && ar[mid] > ar[mid+1]) {
                return ar[mid];
            } else if(ar[mid] > ar[mid-1] && ar[mid] < ar[mid+1]) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }

        return ans;
    }

}