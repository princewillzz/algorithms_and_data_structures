import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class shiv {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine().trim();

        if (isPalindrome(str))
            System.out.println(0);
        else
            System.out.println(solve(str, n));

    }

    static int solve(String str, int n) {
        int ans = Integer.MAX_VALUE;

        int curr1 = equal(str, n);
        int curr2 = greater(str, n);
        int curr3 = lesser(str, n);

        if (curr1 >= curr2 && curr1 >= curr3)
            ans = curr1;
        else if (curr2 >= curr1 && curr2 >= curr3)
            ans = curr2;
        else
            ans = curr3;

        return ans;
    }

    static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

}