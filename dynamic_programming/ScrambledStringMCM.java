import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScrambledStringMCM {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for (String s : str)
            ar[index++] = Integer.parseInt(s);
        int val = Integer.parseInt(br.readLine().trim());

        // System.out.println(solve(ar, val));

    }

}