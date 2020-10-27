import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubArray{
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for(String s: str) ar[index++] = Integer.parseInt(s);
        int val = Integer.parseInt(br.readLine().trim());
        
        System.out.println(solve(ar, ar.length, val));

    }

    static List<Integer> solve(int[] ar, int n, int k) {
        if(ar.length == 0 || k < 0) return new ArrayList<>();
        LinkedList<Integer> alist = new LinkedList<>();
        for(int i = 0; i < k; i++) alist.add(ar[i]);
        int j = 0;
        for(int i = 1; i < n-k+1; i++) {
            if(ar[i] > ar[j]) {
                while(j < i) {
                    alist.addLast(ar[j+k]);
                    alist.removeFirst();
                    j++;
                }
            }
        }

        return alist;
    }

}