import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Basics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        print(n);
    }

    static void print(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        // For n -> 0 reverse
        System.out.print(n + " ");
        print(n - 1);
        // for 0 -> n
        // System.out.print(n + " ");

    }
}