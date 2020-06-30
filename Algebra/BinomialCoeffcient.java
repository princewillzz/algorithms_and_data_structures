import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinomialCoeffcient{
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine().trim());
        int k = Integer.parseInt(br.readLine().trim());
        
        System.out.println(solve(n, k));

    }
    static long solve(int n, int k) {
        long ans = 1;

        if(n-k > k) k = n-k;

        for(int i = 0; i < k; i++) {
            ans *= (n-i);
            ans /= (i+1);
        }

        return ans;
    }

}