import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ReverseAStack{
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
       
        Stack<Integer> stack = new Stack<>();
        for(String s: str) stack.push(Integer.parseInt(s));
        
        
        System.out.println(reverse(stack));

    }
    static Stack<Integer> reverse(Stack<Integer> stack) {
        if(stack.isEmpty()) return stack;

        stack = helper(stack, new Stack<Integer>());

        return stack;
    }
    static Stack<Integer> helper(Stack<Integer> stack, Stack<Integer> newStack) {
        if(stack.isEmpty()) return newStack;

        newStack.push(stack.pop());
        helper(stack, newStack);

        return newStack;
    }

}