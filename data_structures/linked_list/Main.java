public class Main {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < args.length; i++) {
            try {
                list.insert(Integer.parseInt(args[i]));
            } catch (Exception e) {
                System.out.println(args[i] + " is not integer!!");
            }
        }

        System.out.println(list);

        list.reverse();

        System.out.println("reversed: " + list);


    }

}
