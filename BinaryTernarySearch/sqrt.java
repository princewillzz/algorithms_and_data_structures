import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sqrt{
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.printf("%f\n",root((double)n));
        
    }
    static double root(double n) {
        double start = 1, end = n;
        while(end-start > 1e-9) {
            double mid = start+(end-start)/2;
            double sq = mid*mid;
            //System.out.println(sq+" "+start+" "+end);
            if(sq > n) {
                end = mid;
            } else {
                start = mid;
            }
            
        }
        return start+(end-start);
    }
    static int solve(int n) {
        int start = 1, end = n;
        while(start <= end) {
            int mid = start + (end-start)/2;
            int sqrt = mid*mid;
            if(sqrt == n) return mid;
            if(sqrt < n) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }


}