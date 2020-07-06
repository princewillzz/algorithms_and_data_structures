import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeFactorization {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        
        solve2(n);

    }
    
    
    static void solveSeive(int n) {
        byte[] primes = new byte[n+1];
        primes[0] = primes[1] = 1;
        for(int i = 0; i <= (int)Math.sqrt(n); i++) {

            if(primes[i] == 1) continue;
            for(int j = i*i; j <= n; j+=i) {
                primes[j] = 1;
            }
        }int temp = n;
        for(int i = 2; i <= n; i++) {
            if(primes[i] == 1) continue;
            while(temp%i == 0) {
                temp/=i;
                System.out.print(i+"*");
            }
        }
        System.out.println();
    }
    static void solve2(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {
                System.out.print(i + "*");
                n /= i;
            }
        }
        if (n != 1)
            System.out.print(n);
        System.out.println();
    }

    static void solve(int n) {
        if (n <= 1)
            return;

        if (isPrime(n)) {
            System.out.println(n);
            return;
        }

        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                solve(n / i);
                return;
            }
        }
    }

    static boolean isPrime(int num) {
        int i = 2;
        while (i <= (int) Math.sqrt(num)) {
            if (num % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

}