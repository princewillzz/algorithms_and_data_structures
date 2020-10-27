import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * QuickSort
 */
public class QuickSort {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().trim().split(" ");
        int ar[] = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            ar[i] = Integer.parseInt(input[i]);
        }

        quickSort(ar, 0, ar.length - 1);

        for (int element : ar)
            System.out.print(element + " ");

    }

    static void quickSort(int ar[], int start, int end) {
        if (end < start)
            return;

        int pivot = partition(ar, start, end);

        quickSort(ar, start, pivot - 1);
        quickSort(ar, pivot + 1, end);

    }

    static int partition(int ar[], int start, int end) {

        int marker = start;
        int index = start;

        while (index < end) {
            if (ar[index] < ar[end]) {
                int temp = ar[marker];
                ar[marker] = ar[index];
                ar[index] = temp;

                marker++;
                index++;
            } else {
                index++;
            }
        }

        int temp = ar[marker];
        ar[marker] = ar[end];
        ar[end] = temp;

        return marker;
    }
}
// 1 -1 3 2 -> -1 1 2 3