import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LowerBound{
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for(String s: str) ar[index++] = Integer.parseInt(s);

        int n = Integer.parseInt(br.readLine());
        Arrays.sort(ar);
        System.out.println(searchLowerBound(ar, n));
        System.out.println(searchUpperBound(ar, n));
    }
    static int searchUpperBound(int ar[], int val) {
        int ans = -1, l = 0, r = ar.length-1;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if(ar[mid] <= val) {
                ans = ar[mid];
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return ans;
    }

    static int searchLowerBound(int ar[], int val) {
        int ans = -1, l = 0, r = ar.length-1;
        while(l <= r) {
            int mid = l+(r-l)/2;
            if(ar[mid] >= val) {
                ans = ar[mid];
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return ans;
    }

}