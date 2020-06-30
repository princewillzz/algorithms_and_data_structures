import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Catalan{
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // int val = Integer.parseInt(br.readLine().trim());
        // long ar[] = new long[val+1];
        for(int i = 0; i < 30; i++)
        System.out.println(catalan_optimised(i));
    }
    /* 
        Catalan number has the formula
            catalan(0) = 1 ans also catalan(1) = 1
            catalan(n+1) = sum of (catalan(i)*catalan(n)) , where i = 0 -> n && n = n -> 0

    */
    static long binomialCoeffiecient(int n, int k) {
        long ans = 1;

        if(n-k > k) k = n-k;

        for(int i = 0; i < k; i++) {
            ans *= (n-i);
            ans /= (i+1);
        }

        return ans;
    }
    static long catalan_optimised(int n) {
        long coef = binomialCoeffiecient(2*n, n);

        return coef/(n+1);
    }
    static long catalan(int n, long[] ar) {
        if(ar[n] != 0) return ar[n];
        long res = 0;
        if(n <= 1) return 1;
        n--;
        for(int i = 0; i <= n; i++) {
            long first = catalan(i, ar);
            ar[i] = first;
            long second = catalan(n-i, ar);
            ar[n-i] = second;
            res+= first*second;
        }
        
        return res;
    }

}