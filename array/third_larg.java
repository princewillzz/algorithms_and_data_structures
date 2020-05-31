
import java.util.*;

class third_larg {
    public static void main(String[] args) {
        System.out.println("Harsh");
        third_larg obj =  new third_larg();
        ArrayList<Integer> ar = new ArrayList<Integer>();
        ar.add(90);
        ar.add(80);
        ar.add(2);
        ar.add(8);
        int a = obj.ret(ar);       
        System.out.println(a);
    }

    int ret(ArrayList<Integer> ar) {
        Collections.sort(ar);
        //int n = ar.size();
        ar.forEach((n) -> n=2);
        return ar.get(2);
    }
}