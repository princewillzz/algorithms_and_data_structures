import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test{
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        List<Integer[]> alist = new ArrayList<Integer[]>();
        Integer ar[] = {1, 2, 3};
        alist.add(ar);

        alist.add(new Integer[]{1212, 5});
        

        testing(alist);

    }
    static void testing(List<Integer[]> list) {

        for(int i = 0; i < list.size(); i++) {
            //Integer ar[] = list.get(i);
            for(int j = 0; j < list.get(i).length; j++) System.out.print(list.get(i)[j]+" ");
            System.out.println();
        }

    }

}