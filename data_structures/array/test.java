import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test{
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            String s[] = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);

            System.out.println(solve(a, b, c));
        }
        

    }
    static int solve(int a, int b, int c) {
        int ans = 0;
        if(a > b) {
            int t = b;
            b = a;
            a = t;
        }
        boolean flag = true;
        while(a <= c && b <= c) {
            ans++;
            if(flag) {
                a += b;
                flag = false;
            } else {
                b += a;
                flag = true;
            }
            if(a < 0 || b < 0) break;
        }

        return ans;
    }

}