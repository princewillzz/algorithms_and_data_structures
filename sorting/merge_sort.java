import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class merge_sort {
    public static void main(String argv[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp = br.readLine().trim().split(" ");
		int array[] = new int[inp.length];
		for(int i = 0; i < inp.length; i++) array[i] = Integer.parseInt(inp[i]);
        merge_sort ms = new merge_sort();
		array = ms.sort(array);

		for(int ele: array) System.out.print(ele + " ");
		
    }
    public int[] sort(int[] ar) {
        return optimisedMergeSort(ar, 0, ar.length-1);
        
    }
    int[] mergeSort(int[] ar, int left, int right) {
        int ans[] = new int[right-left+1];
        for(int i = left, index=0; i <= right; i++, index++) ans[index] = ar[i];
        if(left >= right) return ans;
        int mid = right/2 + left/2;
        int a[] = mergeSort(ar, left, mid);
        int b[] = mergeSort(ar, mid+1, right);
        ans = merge(a, b);
        return ans;

    }
    int[] merge(int[] a, int[] b) {
        int len1 = a.length, len2 = b.length, index = 0, i = 0, j = 0;
        int ans[] = new int[len1+len2];
        while(i < len1 && j < len2) {
            if(a[i] < b[j]) {
                ans[index++] = a[i];
                i++; 
            } else {
                ans[index++] = b[j];
                j++;
            }
        }
        while(i < len1) ans[index++] = a[i++];
        while(j < len2) ans[index++] = b[j++];
        return ans;
    }

    int[] optimisedMergeSort(int[] ar, int left, int right) {
        if(left >= right) {
            /*int a[] = new int[1]; 
            a[0] = ar[left];*/
            return new int[] {ar[left]};
        }
        int mid = left/2+right/2;
        optimisedMergeSort(ar, left, mid);
        optimisedMergeSort(ar, mid+1, right);
        ar = optimisedMerge(ar, left, mid, mid+1, right);
        //ar = merge(optimisedMergeSort(ar, left, mid), optimisedMergeSort(ar, mid+1, right));
        return ar;
    }
    int[] optimisedMerge(int ar[], int start1, int end1, int start2, int end2) {
        int ans[] = new int[(end1-start1+1) + (end2-start2+1)], index = 0, i = start1;
        while(start1 <= end1 && start2 <= end2) {
            if(ar[start1] < ar[start2]) ans[index++] = ar[start1++];
            else ans[index++] = ar[start2++];
        }
        while(start1 <= end1) ans[index++] = ar[start1++];
        while(start2 <= end2) ans[index++] = ar[start2++];
        index = 0;
        while(i <= end2) {
            ar[i++] = ans[index++];
        }
        return ar;
    }
}