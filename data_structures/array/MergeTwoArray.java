import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeTwoArray{
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1[] = br.readLine().trim().split(" ");
        
        int a[] = new int[s1.length];
        int index= 0;
        for(String s: s1) a[index++] = Integer.parseInt(s);

        merge(a, 0, a.length-1);
        for(int ele: a) System.out.print(ele+" ");
    }
    static void merge(int a[], int left, int right) {
        if(left >= right) return;
        int mid = left/2 + right/2;
        merge(a, left, mid);
        add(a, left, mid);
        merge(a, mid+1, right);
        add(a, mid+1, right);
        add(a, left, right);
    }
    static void add(int a[], int left, int right) {
        int mid = left/2+right/2+1;
        if(left >= right) return;
        int ans[] = new int[right-left+1], index=0;
        for(int i = mid; i <= right; i++) {
            ans[index++] = a[i];
        }
        for(int i = left; i < mid; i++) {
            ans[index++] = a[i];
        }index=0;
        for(int i = left; i <= right;index++, i++) {
            a[i] = ans[index];
        }
    }

}