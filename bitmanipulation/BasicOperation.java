import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BasicOperation {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine().trim());

        System.out.println(isEven(a));

        System.out.println("Enter b : ");
        int b = Integer.parseInt(br.readLine().trim());
        swap(a, b);

    }

    static void swap(int a, int b) {
        System.out.println(a + " " + b);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a + " " + b);
    }

    static boolean isEven(int a) {
        if ((a & 1) == 1) {
            return false;
        }
        return true;
    }
}