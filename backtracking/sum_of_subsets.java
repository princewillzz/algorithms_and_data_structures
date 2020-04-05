import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class sum_of_subsets {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the array: ");
        String s[] = br.readLine().split(" ");
        int ar[] = new int[s.length];
        for(int i = 0; i < s.length; i++) ar[i] = Integer.parseInt(s[i]);

        System.out.print("Enter the target: ");
        int target = Integer.parseInt(br.readLine());


        if(solve(ar.length-1 ,ar ,target) == target) System.out.println("Yes");
        else System.out.println("No");
    }
    static int solve(int n, int ar[], int target) {
        if(target < 0 || n < 0) return 0;
        
        int temp = solve(n-1, ar, target);
        if(temp == target) return temp;
        temp = ar[n] + solve(n-1, ar, target-ar[n]);
        if(temp == target) return temp;
        return 0;
    }
}