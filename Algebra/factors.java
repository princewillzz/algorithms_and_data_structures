import java.util.*;
import java.io.*;

class factors {
    public static void main(String argv[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        factors obj = new factors();

        obj.factor(num);
    }

    boolean isPrime(int num) {
        int i = 2;
        while (i <= num / 2) {
            if (num % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    void factor(int num) {
        System.out.print("The factor are: ");
        int i = 1;
        while (i <= num / 2) {
            if (num % i == 0) {
                System.out.print(i + " ");
            }
            i++;
        }
        System.out.println(num);
    }

    void prime(int num) {
        if (isPrime(num)) {
            System.out.println("Is Prime");
        } else {
            factor(num);
        }
    }
}