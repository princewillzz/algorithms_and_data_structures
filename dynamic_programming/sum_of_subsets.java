import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class sum_of_subsets {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the array: ");
        String s[] = br.readLine().split(" ");
        int ar[] = new int[s.length];
        for(int i = 0; i < s.length; i++) ar[i] = Integer.parseInt(s[i]);

        System.out.print("Enter the target: ");
        int target = Integer.parseInt(br.readLine());
        int mm[][] = new int[s.length][target+1];
        for(int i = 0; i < s.length; i++) {
            Arrays.fill(mm[i], Integer.MAX_VALUE);
        }

        if(solve(ar.length-1 ,ar ,target, mm) == target) System.out.println("Yes");
        else System.out.println("No");
    }
    static int solve(int n, int ar[], int target, int mm[][]) {
        if(target < 0 || n < 0) return 0;
        if(mm[n][target] != Integer.MAX_VALUE) return mm[n][target];
        int temp = solve(n-1, ar, target, mm);
        mm[n][target] = temp;
        if(temp == target) return temp;
        temp = ar[n] + solve(n-1, ar, target-ar[n], mm);
        mm[n][target] = temp;
        if(temp == target) return temp;
        return 0;
    }
}