import java.util.Scanner;

public class FindTwoNonRepeating {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String s[] = sc.nextLine().split(" ");

        int ar[] = new int[s.length];
        int i = 0;
        for(String si: s) ar[i++] = Integer.parseInt(si);

        findTwoNoRepeat(ar);

    }

    static void findTwoNoRepeat(int ar[]) {

        int res = 0;
        for (int i : ar) {
            res ^= i;
        }
        System.out.println(res);
        // TODO

    }


}
