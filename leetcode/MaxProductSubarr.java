import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxProductSubarr {
    public static void main(String argv[]) throws IOException {
        int nums[] = {-2, 3, -4};
        System.out.println(maxProduct(nums));
        

    }
    
    static public int maxProduct(int[] nums) {
        int max = nums[0], maxi = nums[0];
        for(int i = 1; i < nums.length; i++) {
            maxi = Math.max(nums[i], maxi*nums[i]);
            if(maxi > max) max = maxi;
            else maxi = nums[i];

        }
        return max;
    }
    
}