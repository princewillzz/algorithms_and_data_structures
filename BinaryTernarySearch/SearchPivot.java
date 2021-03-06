import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchPivot{
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for(String s: str) ar[index++] = Integer.parseInt(s);
        
        int val = Integer.parseInt(br.readLine());
        //System.out.println(numberOfTimesRotated(ar));
        System.out.println(search(ar, val));
        
    }
    static boolean search(int ar[], int val) {
        
        int start = 0, end = ar.length-1;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(ar[mid] == val) return true;

            if(val >= ar[start] && val <= ar[end]) {
                if(ar[mid] > val) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            } else {
                if(val >= ar[start]) end = mid-1;
                else start = mid+1;
            }

        }
        /*int i = searchPivotIndex(ar);
        if(val >= ar[i] && val <= ar[end]) start = i;
        else end = i-1;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(ar[mid] == val) return true;
            if(ar[mid] > val) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }*/

        return false;
    }
    static int numberOfTimesRotated(int ar[]) {
        int a = (searchPivotIndex(ar));
        //System.out.println(a);
        if(a <= 0) return 0;
        return ar.length - a;
    }
    static int searchPivotIndex(int ar[]) {
        int ans = 0;
        int start = 0, end = ar.length-1;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(ar[mid] <= ar[start] && ar[mid] <= ar[end]) {
                ans = mid;
                end = mid - 1;
            } else if(ar[mid] < ar[end]) end = mid-1;
            else start = mid+1;
        }

        return ans;
    }
    static int searchPivot(int ar[]) {
        int ans = ar[0], l = 0, r = ar.length-1;
        while(l <= r) {
            int mid = l+(r-l)/2;
            //System.out.println(ar[mid]+" "+ar[l]+" "+ar[r]);
            if(ar[mid] <= ar[l] && ar[mid] <= ar[r]) {
                ans = ar[mid];
                r = mid-1;
            }else if(ar[mid] > ar[l] && ar[mid] < ar[r]) {
                r = mid-1;
            } 
            else {
                l = mid+1;
            }
        }
        return ans;
    }

}