import java.util.Arrays;

/**
 * MaxHeap means A[parent] >= A[child] and MinHeap is vice versa
 * 
 * @author Dushyant Singh Shekhawat
 */
public class Heap {
    int[] heap;
    int heapSize;

    public Heap(int capacity, int heapSize) {
        heap = new int[capacity];
        this.heapSize = heapSize;
    }

    public Heap(int[] arr) throws NullPointerException {
        if (arr == null) {
            throw new NullPointerException();
        }
        heap = Arrays.copyOf(arr, arr.length);
        heapSize = heap.length;
    }

    public int getHeapSize() {
        return heapSize;
    }

    public int[] getHeap() {
        return heap;
    }

    /**
     * will only insert the elements equal to the heapSize or the updatedHeap size
     */
    public void updateHeap(int[] updatedHeap) throws NullPointerException {
        if (updatedHeap == null) {
            throw new NullPointerException();
        }
        Arrays.fill(heap, 0);
        System.arraycopy(updatedHeap, 0, heap, 0, heapSize < updatedHeap.length ? heapSize : updatedHeap.length);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return 2 * index + 1;
    }

    private int right(int index) {
        return 2 * index + 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public void maxHeapify(int index) {
        int left = left(index);
        int right = right(index);
        int largest = index;
        if (left < heapSize && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right < heapSize && heap[right] > heap[largest]) {
            largest = right;
        }
        if (largest != index) {
            swap(largest, index);
            maxHeapify(largest);
        }
    }

    public void maxHeapifyIterative(int index) {
        while (true) {
            int left = left(index);
            int right = right(index);
            int largest = index;
            if (left < heapSize && heap[left] > heap[largest]) {
                largest = left;
            }
            if (right < heapSize && heap[right] > heap[largest]) {
                largest = right;
            }
            if (largest != index) {
                swap(largest, index);
                index = largest;
            } else {
                break;
            }
        }
    }

    public void buildMaxHeap(){
        heapSize = heap.length;
        for(int i = heap.length/2; i >= 0; i--){
            maxHeapify(i);
        }
    }

    public void buildMinHeap(){
        heapSize = heap.length;
        for(int i = heap.length/2; i >= 0; i--){
            minHeapify(i);
        }
    }

    public void minHeapify(int index) {
        int left = left(index);
        int right = right(index);
        int smallest = index;
        if (left < heapSize && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if (right < heapSize && heap[right] < heap[smallest]) {
            smallest = right;
        }
        if (smallest != index) {
            swap(smallest, index);
            minHeapify(smallest);
        }
    }

    public void minHeapifyIterative(int index) {
        while (true) {
            int left = left(index);
            int right = right(index);
            int smallest = index;
            if (left < heapSize && heap[left] < heap[smallest]) {
                smallest = left;
            }
            if (right < heapSize && heap[right] < heap[smallest]) {
                smallest = right;
            }
            if (smallest != index) {
                swap(smallest, index);
                index = smallest;
            } else{
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] t1 = null;
        int[] t2 = new int[0];
        int[] t3 = new int[] { 1 };
        int[] t4 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] t5 = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

        Heap h1 = new Heap(t4);
        h1.buildMaxHeap();
        System.out.println(Arrays.toString(h1.getHeap()));

        Heap h2 = new Heap(t5);
        h2.buildMinHeap();
        System.out.println(Arrays.toString(h2.getHeap()));
    }
}