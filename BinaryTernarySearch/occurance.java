import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class occurance{
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for(String s: str) ar[index++] = Integer.parseInt(s);
        int val = Integer.parseInt(br.readLine().trim());
        //System.out.println(searchFirst(ar, val));
        //System.out.println(searchLast(ar, val));
        System.out.println(counter(ar, val));

    }
    static int counter(int ar[], int val) {
    
        int a = searchLast(ar, val);
        if(a == -1) return 0;
        int b = searchFirst(ar, val);

        return a - b + 1;
    }
    static int searchFirst(int ar[], int val) {
        int ans = -1;
        int l = 0, r = ar.length-1;
        while(l <= r) {
            int mid = l+(r-l)/2;
            if(ar[mid] == val) {
                ans = mid+1;
                r = mid-1;
            } else if(ar[mid] < val) l = mid+1;
            else r = mid-1; 
        }

        return ans;
    }
    static int searchLast(int ar[], int val) {
        int ans = -1;
        int start = 0, end = ar.length-1;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(ar[mid] == val) {
                ans = mid+1;
                start = mid+1;
            } else if(ar[mid] < val) start = mid+1;
            else end = mid-1;
        }
        return ans;
    }

}