import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class moveElements {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().trim().split(" ");
        int ar[] = new int[s.length];
        for (int i = 0; i < s.length; i++)
            ar[i] = Integer.parseInt(s[i]);

        move(ar);

    }

    static void move(int[] ar) {
        int pointer = 0;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] < 0) {
                int t = ar[pointer];
                ar[pointer] = ar[i];
                ar[i] = t;
                pointer++;
            }
        }
        for (int ele : ar)
            System.out.print(ele + " ");
    }

}