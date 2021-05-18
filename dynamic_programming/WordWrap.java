import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Stack;

public class WordWrap {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int ar[] = new int[n];
            String inp[] = br.readLine().split(" ");
            int index = 0;
            for (String i : inp)
                ar[index++] = Integer.parseInt(i);

            int max = Integer.parseInt(br.readLine());

            solve(ar, max);

        }

    }

    static void solve(int ar[], int max) {
        Stack<Integer> stack = new Stack<>();

        helper(ar, 0, 0, max, stack);

        System.out.println(stack);

    }

    static int current = Integer.MAX_VALUE;

    static int helper(int ar[], int index, int line, int max, Stack<Integer> stack) {

        if (index > ar.length) {

            System.out.println(stack);
            return line;
        }

        int count = ar[index++];
        while (index < ar.length && count <= max) {
            stack.push(index);
            int l = helper(ar, index, line + 1, max, stack);

            stack.pop();

            count += ar[index++];
        }

        if (index < ar.length) {
            stack.push(index);
            helper(ar, index, line + 1, max, stack);
            stack.pop();
        }
        return line;

    }
}