import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NextLetter{
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();
        char ar[] = new char[str.length()], index = 0;
        for(; index < str.length(); index++) ar[index] = str.charAt(index);
        char val = (char) br.read();
        
        System.out.println(solve(ar, val));

    }
    static char solve(char ar[], char val) {
        int start = 0, end = ar.length-1, ans = -1;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(ar[mid] > val) {
                ans = mid;
                end = mid-1;
            }
            else start = mid+1;
        }
        if(ans == -1) return '_';
        return ar[ans];
    }

}