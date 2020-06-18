import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.io.InputStreamReader;

public class PascalTriangle {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(generate(70));
    }

    static List<LinkedList<Integer>> generate(int n) {
        List<LinkedList<Integer>> ar = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            LinkedList<Integer> number = new LinkedList<>();
            LinkedList<Integer> temp = new LinkedList<>();
            if (i == 1)
                number.add(1);
            else if (i == 2) {
                ;

                number.add(1);
                number.add(1);
            } else {
                temp = ar.get(i - 2);
                number.add(1);
                for (int j = 1; j < i - 1; j++) {
                    int digit = temp.get(j - 1) + temp.get(j);
                    number.add(digit);
                }
                number.add(1);
            }

            ar.add(number);
        }
        return ar;

    }

}
