import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GeometryLRPoint {
    public static void main(String argv[]) throws IOException {
        Scanner sc = new Scanner(System.in);

        int a[] = { sc.nextInt(), sc.nextInt() };
        int b[] = { sc.nextInt(), sc.nextInt() };
        int p[] = { sc.nextInt(), sc.nextInt() };

        locate(a, b, p);

    }

    static void locate(int[] a, int[] b, int[] p) {
        b[0] -= a[0];
        b[1] -= a[1];

        p[0] -= a[0];
        p[1] -= a[1];

        a[0] = a[1] = 0;

        double product = crossProduct(b, p);

        if (product > 0)
            System.out.println("left");
        else if (product < 0)
            System.out.println("right");
        else
            System.out.println("Collinear");
    }

    static double crossProduct(int[] a, int[] b) {
        return (double) ((a[0] * b[1]) - a[1] * b[0]);
    }

}