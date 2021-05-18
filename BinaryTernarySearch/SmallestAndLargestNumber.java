import java.io.*;
import java.util.*;

public class SmallestAndLargestNumber {

    public static void main(String[] args) throws IOException{
        
        System.out.println("Enter an array: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for(String s: str) ar[index++] = Integer.parseInt(s);
        

        findLargestAndSmallest(ar);

    }

    static void findLargestAndSmallest(int ar[]) {

        int larg = findLargest(ar, 0, ar.length-1);
        System.out.println(larg + " is the largest");
        int small = findSmallest(ar, 0, ar.length-1);
        System.out.println(small + " is the Smallest");
    }

    static int findLargest(int ar[], int start, int end) {

        if(start > end) {
            return Integer.MIN_VALUE;
        }
        if(start == end) {
            return ar[start];
        }

        int mid = start + (end-start)/2;

        return Math.max(
            findLargest(ar, start, mid),
            findLargest(ar, mid+1, end)
        );

    }

    static int findSmallest(int ar[], int start, int end) {

        if(start > end) {
            return Integer.MAX_VALUE;
        }
        if(start == end) {
            return ar[start];
        }

        int mid = start + (end-start)/2;

        return Math.min(
            findSmallest(ar, start, mid),
            findSmallest(ar, mid+1, end)
        );

    }
    
}
