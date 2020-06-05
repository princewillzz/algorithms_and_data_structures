import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SmallestWindow {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();

        System.out.println(solve(str, str.length()));

    }

    static int solve(String s, int len) {
        int count = 0, j = 0, smallest = Integer.MAX_VALUE;
        HashMap<Character, Integer> hmap = new HashMap<>(26);

        for (int i = 0; i < len; i++) {
            if (!hmap.containsKey(s.charAt(i))) {
                hmap.put(s.charAt(i), 0);
                j = i;
                count++;
            }
        }
        smallest = count;
        for (int i = 0; i < len; i++) {
            count--;
            hmap.put(s.charAt(i), hmap.get(s.charAt(i)) - 1);
            if (hmap.get(s.charAt(i)) == 0) {
                while (s.charAt(j) != s.charAt(i)) {
                    j++;
                    count++;
                }
                smallest = Math.min(smallest, count);

            }

        }

        return smallest;
    }

}