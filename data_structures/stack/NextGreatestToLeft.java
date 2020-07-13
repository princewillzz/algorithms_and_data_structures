import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class NextGreatestToLeft{
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for(String s: str) ar[index++] = Integer.parseInt(s);
        
        
        find(ar);

    }
    static void find(int[] ar) {
        int ans[] = new int[ar.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < ar.length; i++) {

            
            while(!stack.isEmpty()) {
                if(stack.peek() > ar[i]) {
                    ans[i] = stack.peek();
                    stack.push(ar[i]);
                    break;
                } else stack.pop();
            }
            if(stack.isEmpty()) {
                ans[i] = -1;
                stack.push(ar[i]);
            } 

        }

        for(int i: ans) System.out.print(i+" ");
        System.out.println();
    }

}