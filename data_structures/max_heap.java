import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class max_heap {
    int HEAP_SIZE = 0;
    ArrayList<Integer> heap = new ArrayList<Integer>();
    
    max_heap(int[] ar) {
        HEAP_SIZE = ar.length-1;
        for(int i = 0; i <= HEAP_SIZE; i++) heap.add(ar[i]);

        //int left, right;
        for(int i = (HEAP_SIZE-1)/2; i >= 0; i--) {
            max_heapify(i);
            /* This is also the way of doing this build max heap property
            left = 2 * i + 1; right = 2 * i + 2;
            if(left > HEAP_SIZE) max_heapify(i);
            if(right > HEAP_SIZE) max_heapify(i); 
            if(heap.get(i) < heap.get(left) || heap.get(i) < heap.get(right)) {
                max_heapify(i);
            }*/
        }

        display();
    }


    void max_heapify(int index) {
        int left = 2*index+1, right = 2*index+2;
        if(index > HEAP_SIZE) return;
        else if(left > HEAP_SIZE && right > HEAP_SIZE) return;
        else if(right > HEAP_SIZE) {
            if(heap.get(left) > heap.get(index)) {
                int temp = heap.get(index);
                heap.set(index, heap.get(left));
                heap.set(left, temp);
            }
            return;
        }

        if(heap.get(left) > heap.get(right)) {
            if(heap.get(left) > heap.get(index)) {
                int temp = heap.get(index);
                heap.set(index, heap.get(2*index+1));
                heap.set(2*index+1, temp);
                max_heapify(2*index+1);
            }
        } else {
            if(heap.get(right) > heap.get(index)) {
                int temp = heap.get(index);
                heap.set(index, heap.get(2*index+2));
                heap.set(2*index+2, temp);
                max_heapify(2*index+2);
            }
        }
        return;
    }

    int extract_max() { 
        int maxValue = heap.get(0);
        heap.set(0, heap.get(HEAP_SIZE));
        heap.remove(HEAP_SIZE);
        HEAP_SIZE -= 1;
        max_heapify(0);
        return maxValue;
    }

    void extract_max_all() {
        while(HEAP_SIZE > -1) {
            System.out.print(extract_max() + " ");
            
            //System.out.print("HEAP: ");
            //display();
        }
    }

    void display() {
        for(int ele: heap) System.out.print(ele + " ");
        System.out.println();
    }
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().trim().split(" ");
        int ar[] = new int[s.length];
        for(int i = 0; i < s.length; i++) ar[i] = Integer.parseInt(s[i]);
        max_heap mp = new max_heap(ar);
        
        /*System.out.println(mp.extract_max());
        mp.display();*/

        mp.extract_max_all();

    }

}