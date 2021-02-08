import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsRotation {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine().trim();
        String s2 = br.readLine().trim();

        if (isRotated(s1, s2)) {
            System.out.println("yes");
        } else {
            System.out.println("No");
        }

    }

    static boolean isRotated(String s1, String s2) {

        String s = s1 + s1;

        if (s.indexOf(s2) == -1)
            return false;

        return true;
    }

}