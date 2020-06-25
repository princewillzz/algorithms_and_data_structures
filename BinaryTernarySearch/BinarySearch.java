import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class BinarySearch{
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for(String s: str) ar[index++] = Integer.parseInt(s);

        int n = Integer.parseInt(br.readLine());
        Arrays.sort(ar);
        System.out.println(searchLowerBound(ar, n));

    }
    static int searchLowerBound(int ar[], int val) {
        int x = 0, n = ar.length;
        if(ar[0] > val) return ar[0];
        for(int b = n/2; b>=1; b/=2) {
            while(b+x < n && ar[b+x] <= val) x+=b;
        }
        return x+1 < n? ar[x+1]: -1;
    }
    static int search(int ar[], int val) {
        int l = 0, r = ar.length-1;
        while(r-l > 0) {
            int m1 = l+(r-1)/3;
            int m2 = r-(r-1)/3;
            if(val == ar[m1]) return val;
            if(val == ar[m2]) return val;
            if(ar[m1] < ar[m2]) l = m1+1;
            else if(ar[m1] > ar[m2]) r = m2-1;
            else {
                l = m1;
                r = m2;
            }
        }
        
        return ar[l];
    }
    
    static int searchClosest(int ar[], int val) {
        int b = ar.length/2, k = 0;
        for(int i = b; i >= 1; i/=2) {
            while(k+i < ar.length && ar[i+k] < val) k+=i;
        }
        return k+1 < ar.length && ar[k+1]-val < val-ar[k]? ar[k+1]: ar[k];
    }
    static boolean bsearch(int ar[], int val) {

        int left = 0, right = ar.length-1;
        while(left <= right) {
            int mid = left/2 + (right+1)/2;
            if(ar[mid] == val) return true;
            else if(ar[mid] < val) left = mid+1;
            else right = mid-1;
        }

        return false;
    }

}