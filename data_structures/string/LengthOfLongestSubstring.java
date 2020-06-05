import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class LengthOfLongestSubstring {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();

        System.out.println(LongestSub(str));

    }

    static int LongestSub(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        char ar[] = s.toCharArray();
        if (ar.length == 0)
            return 0;

        for (char c : ar)
            if (!window.containsKey(c))
                window.put(c, 0);
        // System.out.println(window);
        int i = 0, j = 1, max = 1, currLen = 1;
        window.put(ar[0], 1);
        while (j < ar.length) {

            if (window.get(ar[j]) == 0) {
                window.put(ar[j], 1);
                currLen++;
                j++;
                if (max < currLen)
                    max = currLen;

            } else {
                window.put(ar[i], 0);
                i++;

                currLen--;
            }

        }
        /*
         * while (i < ar.length) { while (j < ar.length) { if (window.get(ar[j]) >= 1) {
         * window.put(ar[i], 0); break; } currLen++; window.put(ar[j], window.get(ar[j])
         * + 1); j++; }
         * 
         * if (currLen > max) max = currLen; currLen--; i++; }
         */

        return max;
    }

}
// https://www.youtube.com/watch?v=s2ZGeNeKpuI