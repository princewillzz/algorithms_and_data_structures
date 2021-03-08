import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordWrap {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int ar[] = new int[n];
            String inp[] = br.readLine().split(" ");
            int index = 0;
            for(String i: inp) ar[index++] = Integer.parseInt(i);

            int max = Integer.parseInt(br.readLine());

            solve(ar, max);

        }

    }

    static void solve(int ar[], int max) {

        

    }
}