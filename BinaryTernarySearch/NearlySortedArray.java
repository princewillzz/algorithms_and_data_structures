import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NearlySortedArray{
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(", ");
        int ar[] = new int[str.length], index = 0;
        for(String s: str) ar[index++] = Integer.parseInt(s);
        int val = Integer.parseInt(br.readLine().trim());
        
        System.out.println(solve(ar, val));

    }
    static boolean solve(int ar[], int val) {
        int start = 0, end = ar.length-1;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(ar[mid] == val || (mid-1 >= 0 && ar[mid-1] == val) || (mid+1 < ar.length && ar[mid+1] == val)) {
                return true;
            }

            if(ar[mid] > val) end = mid-1;
            else start = mid+1;

        }

        return false;
    }

}