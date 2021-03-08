import java.util.Scanner;

public class BasicOfMasking {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {


        // findIthBit();
        // setIthbit();
        // clearbit();
        convert(number(sc.next()), number(sc.next()));
        
    }

    static void convert(int a, int b) {

        // method 2 find xor then count all set bit
        // hack: n & (n-1) clear the last significant bit
        int count = 0;
        int xor = a ^ b;
        while(xor > 0) {
            xor = xor & (xor-1);
            count++;
            
        }
        System.out.println(count);

        // method 1
        int counter = 0;
        while(a > 0 || b > 0) {

            if((a&1) != (b&1) ) counter++;

            a >>= 1;b >>= 1;
        }
        System.out.println(counter);

        

    }

    static void clearbit() {
        int n = sc.nextInt();

        display(n);
        int i = sc.nextInt();

        // method 1
        int mask = 1 << (i-1);
        int t = n;
        if((t & mask) != 0) {
            t = n^mask;
        } 

        display(t);

        // mathod 2
        mask = ~(1 << (i-1));
        display(n&mask);


    }

    static void setIthbit() {

        int n = sc.nextInt();

        while(true) {
            display(n);
            
            int i = sc.nextInt();

            int mask = (1 << (i-1));

            n = n|mask;

            display(n);
        }

    }

    static void findIthBit() {
        // Find ith bit
        
        int n = sc.nextInt();
        display(n);

        int i = sc.nextInt();

        // Method one -> right shift n by i then check the last bits value
        int t = n;
        System.out.println(t >> (i-1) & 1) ;

        // Method 2 create a mask by right shift one i times and & with n which will give 0 if the ith bit is 0 or else any positive number
        int mask = 1 << (i-1);

        System.out.println((mask & n) == 0? 0: 1);

        
    }



    static void display(int n) {
        if(n == 0) {
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.append(n%2);
            n/=2;
        }
        System.out.println(sb.reverse());

    }

    static int number(String s) {

        int ans = 0;
        for (int p = 0,  i = s.length()-1; i >= 0; i--, p++) {

            if(s.charAt(i) == '1')
                ans += (int) Math.pow(2, p);
            

        }

        System.out.println(ans);
        return ans;

    }


}


