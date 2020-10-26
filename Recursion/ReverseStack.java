import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ReverseStack {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        Stack<String> st = new Stack<>();
        for (String s : str)
            st.push(s);

        solve(st);
        System.out.println(st);

    }

    static void solve(Stack<String> st) {
        if (st.size() == 1) {
            return;
        }
        String temp = st.pop();
        solve(st);
        insert(st, temp);

    }

    static void insert(Stack<String> st, String temp) {
        if (st.empty()) {
            st.push(temp);
            return;
        }
        String item = st.pop();
        insert(st, temp);
        st.push(item);
    }

}