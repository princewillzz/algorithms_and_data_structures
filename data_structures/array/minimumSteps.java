import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class minimumSteps {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().trim().split(" ");
        int ar[] = new int[s.length];
        for (int i = 0; i < s.length; i++)
            ar[i] = Integer.parseInt(s[i]);

        HashSet<Integer> h = new HashSet<>();
        h.add(1);
        System.out.println(h.contains(1));

        System.out.println(MinimumSteps(ar, 0, 0));
    }

    static int MinimumSteps(int ar[], int position, int step) {
        if (position >= ar.length - 1)
            return step;
        if (ar[position] == 0)
            return -1;

        int max = Integer.MAX_VALUE;
        for (int i = 1; i <= ar[position]; i++) {
            int curr = MinimumSteps(ar, position + i, step + 1);
            if (curr == -1)
                continue;
            if (curr < max)
                max = curr;
        }
        if (max == Integer.MAX_VALUE)
            return -1;
        return max;
    }

}