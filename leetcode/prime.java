import java.util.Arrays;
import java.util.Scanner;

public class prime {
    public static void main(String argv[]) {
        Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(), b = sc.nextInt();
		int ar[] = segmentedSeive(a, b);
		
		for(int val: ar)
			if(val != 0)
				System.out.print(val + " ");
		
		//if(isPrime(a)) System.out.println("\nIT is PRIME");
		
	}
	static int[] seive(int end) {
		int ans[] = new int[end+1];ans[0] = 0;ans[1] = 0;
		for(int i = 2; i <= end; i++) {
			ans[i] = i;
		}
		for(int i = 2; i <= end; i++) {
			if(ans[i] == 1) {
				for(int j = i*i; j <= end && j > 1; j+=i) {
					ans[j] = 0;
				}
			}
		}
		return ans;
	}
	static boolean isPrime(int a) {
		if(a < 2) return false;
		if(a == 2) return true;
		for(int i = 3; i <= (int) Math.sqrt(a); i++) 
			if(a % i == 0) return false;
		
		return true;
	}
	static int[] segmentedSeive(int a, int b) {
		if(a < 2) a = 2;
		int[] ans = new int[b-a+1];
		int[] seive_arr = new int[(int)Math.sqrt(b)+2];
		Arrays.fill(seive_arr, 1);
		for(int i = 0, val = a; i < ans.length; i++, val++) ans[i] = val;
		
		for(int i = 2; i < seive_arr.length; i++) {
			if(seive_arr[i] == 1) {
				for(int j = i*i; j < seive_arr.length && j > 0; j+=i) {
					seive_arr[j] = 0;
				}
				int rem = a%i;
				if(rem != 0) rem = i - rem;
				for(; rem < ans.length; rem += i) {
					if(ans[rem] == i) continue;
					ans[rem] = 0;
				}
			}
		}
		return ans;
	}
}
