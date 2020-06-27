import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchInARotatedArray{
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for(String s: str) ar[index++] = Integer.parseInt(s);
        int n = Integer.parseInt(br.readLine());
        System.out.println(search(ar, n));
    }
    static boolean search(int ar[], int n) {
        int pivot = searchPivot(ar);
        //System.out.println(ar[pivot]);
        int start = 0, end = ar.length-1;
        if(ar[pivot] <= n && ar[end] >= n) {start=pivot;}
        else end = pivot;

        while(start <= end) {
            int mid = start+(end-start)/2;
            if(ar[mid] == n) return true;
            else if(ar[mid] < n) start = mid+1;
            else end = mid-1;
        }

        return false;
    }
    static int searchPivot(int ar[]) {
        int l = 0, r = ar.length-1, ans = 0;
        while(l <= r) {
            int mid = l+(r-l)/2;
            if(ar[mid] <= ar[l] && ar[mid] <= ar[r]) {
                ans = mid;
                r = mid-1;
            }else if(ar[mid] > ar[l] && ar[mid] < ar[r]) {
                r = mid-1;
            } else l = mid+1;
        }
        return ans;
    }

}