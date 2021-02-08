import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class isPowerOfTwo{
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        if((n & (n-1)) == 0) System.out.println("Yes");
        else System.out.println("No");
        

    }

}