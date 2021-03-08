import java.util.*;

public class bitwiseOP {
    public static void main(String argv[]) {
        final Scanner sc = new Scanner(System.in);
        while(true) {
            /*System.out.print("Enter A: ");  int a = sc.nextInt();
            System.out.print("Enter B: ");int b = sc.nextInt();
            
            boolean c ;/*= a & b;
            System.out.println("AND: " + c);

            /*c = a | b;
            System.out.println("OR: " + c);
            // Always print the negative value which is one less than the it's negative value
            c = ~(~a);
            
            System.out.println("Not: " + c);
            c = ~(~b);
            System.out.println("Not: " + c);
            // Always gives the half of the number
            c = a >> b;
            System.out.println("right shift: " + c);
            // Always gives double of the number
            c = a<<b;
            System.out.println("left shift: " + c);*/

            /*c = a^b;
            System.out.println("XOR: " + c);*/

            // Once changes from tue to false it cannot be converted back
            boolean c = false;
            System.out.println("or: " + (c|=sc.nextBoolean()));
            
            break;

            
        }
        

    }
    
    

}