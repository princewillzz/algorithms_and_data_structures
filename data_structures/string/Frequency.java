import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Frequency {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char str[] = br.readLine().toCharArray();

        HashMap<Character, Integer> hmap = new HashMap<>();
        for (int index = 0; index < str.length; index++) {

            if (hmap.containsKey(str[index])) {
                hmap.put(str[index], hmap.get(str[index]) + 1);
            } else {
                hmap.put(str[index], 1);
            }

        }

        for (int index = 0; index < str.length; index++) {

            int count = hmap.get(str[index]);
            if (count > 1) {
                System.out.println(str[index] + " " + count);
            }
            hmap.put(str[index], 0);

        }

    }

}