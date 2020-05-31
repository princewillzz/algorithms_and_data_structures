import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CountPairs {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().trim().split(" ");
        int ar[] = new int[s.length];
        for (int i = 0; i < s.length; i++)
            ar[i] = Integer.parseInt(s[i]);
        System.out.print("sum: ");
        int sum = Integer.parseInt(br.readLine());
        count(ar, sum);
    }

    static void count(int ar[], int sum) {
        int ans = 0;
        HashMap<Integer, Integer> hmap = new HashMap<>();

        for (int element : ar) {
            if (hmap.containsKey(sum - element)) {
                ans += hmap.get(sum - element);
            }
            if (hmap.containsKey(element)) {
                hmap.put(element, hmap.get(element) + 1);
            } else {
                hmap.put(element, 1);
            }

        }

        System.out.println("No. of times: " + ans);
    }

}