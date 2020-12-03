import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MinQuery {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        int ar[] = new int[str.length], index = 0;
        for (String s : str)
            ar[index++] = Integer.parseInt(s);
        
        int n = a.length;

        Integer segmentTree[] = new Integer[4 * n + 1];

        buildTree(a, segmentTree, 0, n - 1, 0);

        for (Integer ele : segmentTree)
            if (ele != null)
                System.out.print(ele + " ");
        System.out.println();
        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            String ch = br.readLine();
            if (ch.equals("u")) {
                String inp[] = br.readLine().trim().split(" ");
                int i = Integer.parseInt(inp[0]);
                int val = Integer.parseInt(inp[1]);
                update(segmentTree, 0, a.length - 1, 0, i, val);
                for (Integer ele : segmentTree)
                    if (ele != null)
                        System.out.print(ele + " ");
                System.out.println();

            } else if (ch.equals("r")) {
                String inp[] = br.readLine().trim().split(" ");
                int sr = Integer.parseInt(inp[0]);
                int er = Integer.parseInt(inp[1]);
                int val = Integer.parseInt(inp[2]);
                rangeUpdate(segmentTree, 0, n - 1, 0, sr, er, val);
                for (Integer ele : segmentTree) {
                    if (ele != null)
                        System.out.print(ele + " ");
                }
                System.out.println();
            } else {
                String inp[] = br.readLine().trim().split(" ");
                int start = Integer.parseInt(inp[0]);
                int end = Integer.parseInt(inp[1]);
                int val = minQuery(segmentTree, start, end, 0, 0, a.length - 1);

                System.out.println(val);
            }
        }
    }

    // Range update
    static void rangeUpdate(Integer[] segmentTree, int start, int end, int index, int sr, int er, int val) {
        if (start > er || end < sr)
            return;

        // leaf node
        if (start == end) {
            segmentTree[index] += val;
            return;
        }
        // partial overlap
        int mid = start + (end - start) / 2;
        rangeUpdate(segmentTree, start, mid, 2 * index + 1, sr, er, val);
        rangeUpdate(segmentTree, mid + 1, end, 2 * index + 2, sr, er, val);
        int left = segmentTree[2 * index + 1] != null ? segmentTree[2 * index + 1] : Integer.MAX_VALUE;
        int right = segmentTree[2 * index + 2] != null ? segmentTree[2 * index + 2] : Integer.MAX_VALUE;
        int ans = Math.min(left, right);
        if (ans != Integer.MAX_VALUE)
            segmentTree[index] = ans;

    }

    // Single index-value update
    static void update(Integer[] segmentTree, int start, int end, int index, int i, int val) {
        if (i < start || i > end)
            return;

        // Reached leaf node
        if (start == end) {
            segmentTree[index] = val;
            return;
        }

        int mid = start + (end - start) / 2;
        update(segmentTree, start, mid, 2 * index + 1, i, val);
        update(segmentTree, mid + 1, end, 2 * index + 2, i, val);
        int left = segmentTree[2 * index + 1] != null ? segmentTree[2 * index + 1] : Integer.MAX_VALUE;
        int right = segmentTree[2 * index + 2] != null ? segmentTree[2 * index + 2] : Integer.MAX_VALUE;
        int v = Math.min(left, right);
        if (v != Integer.MAX_VALUE)
            segmentTree[index] = v;
    }

    static int minQuery(Integer[] segmentTree, int start, int end, int index, int myStart, int myEnd) {
        // base
        // System.out.println(myStart + " " + myEnd);

        // case 0 (No overlap)
        if (end < myStart || start > myEnd) {
            return Integer.MAX_VALUE;
        }

        // case 1 (Full overlap)
        if (myStart >= start && myEnd <= end)
            return segmentTree[index];

        int mid = myStart + (myEnd - myStart) / 2;

        // case 2 (partial overlap)

        int left = minQuery(segmentTree, start, end, 2 * index + 1, myStart, mid);
        int right = minQuery(segmentTree, start, end, 2 * index + 2, mid + 1, myEnd);
        int ans = Math.min(left, right);
        return ans;

    }

    static void buildTree(int a[], Integer segmentTree[], int start, int end, int index) {
        if (start > end)
            return;
        if (start == end) {
            segmentTree[index] = a[start];
            return;
        }
        int mid = start + (end - start) / 2;
        buildTree(a, segmentTree, start, mid, 2 * index + 1);
        buildTree(a, segmentTree, mid + 1, end, 2 * index + 2);
        int leftChildVal = segmentTree[2 * index + 1] != null ? segmentTree[2 * index + 1] : Integer.MAX_VALUE;
        int rightChildVal = segmentTree[2 * index + 2] != null ? segmentTree[2 * index + 2] : Integer.MAX_VALUE;
        int val = Math.min(leftChildVal, rightChildVal);
        if (val != Integer.MAX_VALUE)
            segmentTree[index] = val;

    }
}