
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Pair {
    public char ch;
    public int freq;

    Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

class MaxHeap {
    int HEAPSIZE = 0;
    ArrayList<Pair> heap = new ArrayList<>();

    public boolean isEmpty() {
        if (HEAPSIZE < 1)
            return true;

        return false;
    }

    public Pair extractMax() {
        if (HEAPSIZE < 1) {
            HEAPSIZE = 0;
            return new Pair('#', -1);
        } else if (HEAPSIZE == 1) {
            HEAPSIZE--;
            Pair temp = heap.get(0);
            heap.remove(0);

            return temp;
        }
        Pair temp = heap.get(0);
        heap.set(0, heap.get(HEAPSIZE - 1));
        heap.remove(HEAPSIZE - 1);
        HEAPSIZE--;
        maxHeapify(0);

        return temp;
    }

    void maxHeapify(int index) {
        if (index >= HEAPSIZE)
            return;
        Pair papa = heap.get(index);
        int left = index * 2 + 1, right = index * 2 + 2;
        if (left >= HEAPSIZE && right >= HEAPSIZE)
            return;
        else if (right >= HEAPSIZE) {
            Pair beta = heap.get(left);
            if (papa.freq < beta.freq) {
                char c = papa.ch;
                int f = papa.freq;
                papa.ch = beta.ch;
                papa.freq = beta.freq;
                beta.ch = c;
                beta.freq = f;
                maxHeapify(left);
            }
            return;
        }

        Pair leftBeta = heap.get(left), rightBeta = heap.get(right);
        if (papa.freq >= leftBeta.freq && papa.freq >= rightBeta.freq)
            return;
        if (rightBeta.freq < leftBeta.freq) {
            char c = papa.ch;
            int f = papa.freq;
            papa.ch = leftBeta.ch;
            papa.freq = leftBeta.freq;
            leftBeta.ch = c;
            leftBeta.freq = f;
            maxHeapify(left);
        } else {
            char c = papa.ch;
            int f = papa.freq;
            papa.ch = rightBeta.ch;
            papa.freq = rightBeta.freq;
            rightBeta.ch = c;
            rightBeta.freq = f;
            maxHeapify(right);
        }
    }

    public void insert(Pair e) {
        heap.add(e);
        int parentIndex;
        if (HEAPSIZE % 2 == 0)
            parentIndex = (HEAPSIZE - 2) / 2;
        else
            parentIndex = (HEAPSIZE - 1) / 2;

        if (parentIndex >= 0)
            insertHelp(parentIndex, HEAPSIZE);
        HEAPSIZE++;

    }

    void insertHelp(int index, int childIndex) {
        if (index < 0 || childIndex > HEAPSIZE)
            return;

        Pair beta = heap.get(childIndex);
        Pair papa = heap.get(index);
        if (beta.freq > papa.freq) {
            char c = papa.ch;
            int f = papa.freq;
            papa.ch = beta.ch;
            papa.freq = beta.freq;
            beta.ch = c;
            beta.freq = f;

            int parentIndex;
            if (index % 2 == 0)
                parentIndex = (index - 2) / 2;
            else
                parentIndex = (index - 1) / 2;

            insertHelp(parentIndex, index);
        }
    }

    public void display() {
        for (int i = 0; i < HEAPSIZE; i++) {
            System.out.print(heap.get(i).ch + "->" + heap.get(i).freq + " ");
        }
        System.out.println();
    }
}

class arrangingString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        solve(str.toCharArray(), str.length());

    }

    static void solve(char[] str, int n) {
        MaxHeap heap = new MaxHeap();
        int count[] = new int[26];
        Arrays.fill(count, 0);
        for (int i = 0; i < n; i++) {
            count[str[i] - 'a']++;
        }
        char ans[] = new char[n];

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                char c = (char) Integer.parseInt(String.valueOf(i + 'a'));
                Pair p = new Pair(c, count[i]);
                heap.insert(p);
            }
        }
        int index = 0;
        Pair prev = new Pair('*', -1);
        while (!heap.isEmpty()) {

            Pair p = heap.extractMax();
            ans[index++] = p.ch;
            p.freq--;
            if (prev.freq > 0)
                heap.insert(prev);
            prev = p;
        }
        if (index == n)
            System.out.println(ans);
        else
            System.out.println("'Not possible'");

    }
}
