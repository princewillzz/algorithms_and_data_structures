import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

        // if(subset(ar, target)) System.out.println("true");
        // else System.out.println("No");
        ArrayList<Integer> alist = new ArrayList<>();
        if(solve2(ar, ar.length, target, new int[ar.length+1][target+1], alist) == target) {
            System.out.println("Found");
            System.out.println(li);
        }
    }
    
    static ArrayList<Integer> li = new ArrayList<>();
    
    static int solve2(int ar[], int n, int target, int[] memo[], ArrayList<Integer> alist) {
        if(target < 0 || ar.length == 0) return -1;
        
        if(target == 0) {
            //System.out.println(alist);
            li.addAll(alist);
            return target;
        } else if(n <= 0) return -1;
        if(memo[n][target] != 0) return memo[n][target];
        if(ar[n-1] <= target) {
            alist.add(ar[n-1]);
            memo[n][target-ar[n-1]] = solve2(ar, n-1, target-ar[n-1], memo, alist);
            if(memo[n][target-ar[n-1]]+ar[n-1] == target) return target;
            alist.remove(alist.size()-1);
            memo[n][target] = solve2(ar, n-1, target, memo, alist);
            if(memo[n][target] == target) return target;
        } else {
            //alist.remove(ar.length-n);
            memo[n][target] = solve2(ar, n-1, target, memo, alist);
            return memo[n][target];
        }
        return -1;
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
    static boolean subset(int ar[], int target) {
        boolean memo[][] = new boolean[ar.length+1][target+1];

        for(int i= 0; i < ar.length+1; i++) {
            for (int j = 0; j < target+1; j++) {
                if(i == 0 && j == 0) memo[i][j] = true;
                if(j == 0) memo[i][j] = true;
                else memo[i][j] = false;
            }
        }

        for (int i = 1; i < ar.length+1; i++) {
            for (int j = 1; j < target+1; j++) {
                if(ar[i-1] <= j) {
                    memo[i][j] = memo[i-1][j-ar[i-1]] || memo[i-1][j];
                } else {
                    memo[i][j] = memo[i-1][j];
                }
            }
        }

        return memo[ar.length][target];
    }
}