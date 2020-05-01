import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class insertion_sort {
    public static void main(String argv[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp = br.readLine().trim().split(" ");
		int array[] = new int[inp.length];
		for(int i = 0; i < inp.length; i++) array[i] = Integer.parseInt(inp[i]);

		insertion_sort is = new insertion_sort();
		is.sort(array);

		for(int ele: array) System.out.print(ele + " ");
		
	}
	public void sort(int[] ar) {
		int n = ar.length;
		for(int i = 1; i < n; i++) {
			/*for(int j=i; j > 0 && ar[j] < ar[j-1]; j--) {
			
				int temp = ar[j];
				ar[j] = ar[j-1];
				ar[j-1] = temp;
			
			}*/
			int j = i;
			while(j > 0 && ar[j] < ar[j-1]) {
				int temp = ar[j];
				ar[j] = ar[j-1];
				ar[--j] = temp;
			}
		}
		
	}

}