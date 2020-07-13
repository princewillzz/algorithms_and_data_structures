import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumAreaInHistogram{
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for(String s: str) ar[index++] = Integer.parseInt(s);
        
        
        System.out.println(maxArea(ar));

    }
    static int maxArea(int ar[]) {
        int ans[] = new int[]{0, 1};
        
        int maxArea = ar[ans[0]] > ar[ans[1]]? ar[ans[1]]: ar[ans[0]];
        for(int i = ar.length-2; i >= 0; i--) {

            int sum1 = Math.min(ar[i], ar[ans[0]])* (i-ans[0]);
            int sum2 = Math.min(ar[i], ar[ans[1]]) * (i-ans[1]);

            if(sum1 > sum2) {
                if(sum1 > maxArea) {
                    maxArea = sum1;
                    ans[1] = ans[0];
                    ans[0] = i;
                }
            } else {
                if(sum2 > maxArea) {
                    maxArea = sum2;
                    ans[0] = i;
                }
            }


        }
        
        return maxArea;
    }

}