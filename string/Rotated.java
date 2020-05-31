import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Rotated {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine().trim();
        String b = br.readLine().trim();
        String c = br.readLine().trim();
        int n = c.length(), al = a.length(), bl = b.length();
        int index1 = 0, index2 = 0;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            char ch = c.charAt(i);
            if (index1 < al && ch == a.charAt(index1)) {
                index1++;
            } else if (index2 < bl && ch == b.charAt(index2)) {
                index2++;
            } else {
                flag = false;
                break;
            }
        }
        if (flag)
            System.out.println("yes");
        else
            System.out.println("no");

        /*
         * int n = s.length(), index = 0; char ar[] = new char[n];
         * 
         * int a[] = new int[200]; Arrays.fill(a, 0);
         * 
         * for (int i = 0; i < n; i++) { char c = s.charAt(i); a[c] += 1; if (a[c] < 2)
         * { ar[index++] = c; } } System.out.println(ar);
         */

        /*
         * char s1[] = str1.toCharArray(); String str2 = br.readLine().trim(); char s2[]
         * = new char[s1.length * 2]; String temp = str1.concat(str1); int start = 0,
         * end = str2.length() - 1; int n = temp.length(); boolean flag = false;
         */

        /*
         * if (str1.length() == str2.length()) { if (temp.indexOf(str2) != -1) flag =
         * true; }
         */

        /*
         * int index = 0; while (end < n) {
         * 
         * if (temp.charAt(start) == str2.charAt(0)) { flag = true; for (int i = start;
         * i < end + 1; i++) { if (str2.charAt(index++) != temp.charAt(i)) { flag =
         * false; break; } } if (flag) break;
         * 
         * } start++; end++; index = 0; }
         * 
         * if (!flag) System.out.println("NO"); else System.out.println("YES");
         * 
         * int n = str2.length(); for (int i = 0; i < n; i++) s2[i] = str2.charAt(i);
         * 
         * int start = 0, end = s1.length - 1; while (!Arrays.equals(s1, 0, s1.length -
         * 1, s2, start, end)) { end++; if (end >= s2.length) {
         * System.out.println("NO"); return; } s2[end] = s2[start]; start++;
         * 
         * }
         */

    }

}