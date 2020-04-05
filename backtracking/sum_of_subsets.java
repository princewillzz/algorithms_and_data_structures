import java.util.Scanner;

class sum_of_subsets {
    public static void main(String[] args) {
        java.util.Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int 
        if(solve(5, ar, sum) == 2) System.out.println("Yes");
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