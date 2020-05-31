/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            HashSet<Integer> hmap = new HashSet<>();
            int n = sc.nextInt();
            int ar[] = new int[n];
            int repeated[] = new int[20], k = 0;
            for (int i = 0; i < n; i++) {
                ar[i] = sc.nextInt();
                if (hmap.contains(ar[i]))
                    repeated[k++] = ar[i];
                else
                    hmap.add(ar[i]);
            }
            System.out.println(repeated[0] + " " + repeated[1]);

        }

    }
}