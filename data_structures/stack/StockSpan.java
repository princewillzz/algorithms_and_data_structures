import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StockSpan{
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for(String s: str) ar[index++] = Integer.parseInt(s);

        find(ar);
    }
    static void find(int[] ar) {
        int ans[] = new int[ar.length];

        var stack = new Stack<Integer>();
        for(int i = 0; i < ar.length; i++) {

            if(stack.isEmpty()) {
                stack.push(i);
                ans[i] = i+1;
            } else {
                while(!stack.isEmpty()) {
                    int index = stack.peek();
                    if(ar[index] > ar[i]) {
                        ans[i] = i-index;
                        stack.push(i);
                        break;
                    } else {stack.pop();}
                    if(stack.isEmpty()) {
                        ans[i] = i+1;
                        stack.push(i);
                        break;
                    }
                }
            }

        }
        for(int i: ans) System.out.print(i+" ");
        System.out.println();
    }

}