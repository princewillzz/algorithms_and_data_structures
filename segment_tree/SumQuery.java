import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumQuery {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for (String s : str)
            ar[index++] = Integer.parseInt(s);
        
        int tree[] = new int[4 * ar.length];
        buildTree(ar, tree, 0, ar.length - 1, 0);
        for (int i : tree) {
            System.out.print(i + " ");
        }
        System.out.println();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s[] = br.readLine().split(" ");
            if (s[0].equals("q")) {
                int l = Integer.parseInt(s[1]);
                int r = Integer.parseInt(s[2]);
                int ans = query(tree, 0, ar.length - 1, 0, l, r);
                System.out.println(ans);
            } else {
                int updateIndex = Integer.parseInt(s[1]);
                int updateValue = Integer.parseInt(s[2]);
                update(tree, 0, ar.length - 1, 0, updateIndex, updateValue);
            }
        }

    }

    static void update(int tree[], int start, int end, int index, int updateIndex, int updateValue) {
        if (updateIndex < start || updateIndex > end)
            return;

        if (start == end) {
            tree[index] = updateValue;
            return;
        }

        int mid = start + (end - start) / 2;
        update(tree, start, mid, 2 * index + 1, updateIndex, updateValue);
        update(tree, mid + 1, end, 2 * index + 2, updateIndex, updateValue);
        tree[index] = tree[2 * index + 1] + tree[2 * index + 2];

    }

    static int query(int tree[], int start, int end, int index, int rangeStart, int rangeEnd) {
        if (rangeEnd < start || rangeStart > end) {
            return 0;
        }

        if (rangeStart <= start && rangeEnd >= end) {
            return tree[index];
        }

        int mid = start + (end - start) / 2;
        int left = query(tree, start, mid, 2 * index + 1, rangeStart, rangeEnd);
        int right = query(tree, mid + 1, end, 2 * index + 2, rangeStart, rangeEnd);

        return left + right;
    }

    static void buildTree(int ar[], int tree[], int start, int end, int index) {
        if (start > end) {
            return;
        }
        if (start == end) {
            tree[index] = ar[start];
            return;
        }
        int mid = start + (end - start) / 2;
        buildTree(ar, tree, start, mid, 2 * index + 1);
        buildTree(ar, tree, mid + 1, end, 2 * index + 2);
        int left = tree[2 * index + 1];
        int right = tree[2 * index + 2];

        tree[index] = left + right;

    }

}