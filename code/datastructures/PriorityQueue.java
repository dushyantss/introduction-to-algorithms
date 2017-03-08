import java.util.Arrays;

public class PriorityQueue{
    int[] heap;
    int heapSize;

    // create an empty heap with zero initial heapSize
    public PriorityQueue(int capacity){
        heap = new int[capacity];
        heapSize = 0;
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

    public void sort(){
        buildMaxHeap();
        for(int i = heap.length - 1; i > 0; i--){
            swap(i, 0);
            heapSize--;
            maxHeapify(0);
        }
    }

    public int max(){
        return heap[0];
    }

    public int extractMax() throws Exception{
        if(heapSize < 1){
            throw new Exception();
        }
        int max = heap[0];
        heap[0] = heap[--heapSize];
        buildMaxHeap();
        return max;
    }

    public void increaseKey(int index, int key) throws Exception{
        if(index < 0 || index > heap.length - 1 || key < heap[index]){
            throw new Exception();
        }
        heap[index] = key;
        while(parent(index) >= 0 && heap[parent(index)] < heap[index]){
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public void insert(int key) throws IndexOutOfBoundsException, Exception{
        if(heapSize == heap.length){
            throw new IndexOutOfBoundsException();
        }
        heap[heapSize] = Integer.MIN_VALUE;
        heapSize++;
        increaseKey(heapSize - 1, key);

    }

    public static void main(String[] args) throws IndexOutOfBoundsException, Exception {
        int[] t1 = null;
        int[] t2 = new int[0];
        int[] t3 = new int[] { 1 };
        int[] t4 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] t5 = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        int[] t6 = new int[] { 9, 8, 7, 6, 15, 24, 3, 2, 13 };

        PriorityQueue queue = new PriorityQueue(16);
        queue.insert(13);
        queue.insert(16);      
        queue.insert(11);      
        queue.insert(1);      
        queue.insert(136);      
        queue.insert(14);      
        queue.insert(56);

        System.out.println(Arrays.toString(queue.getHeap()));   
        int max = queue.extractMax();
        System.out.println(Arrays.toString(queue.getHeap()) + " " + max);  
        queue.increaseKey(3, 4);
        System.out.println(Arrays.toString(queue.getHeap()));
    }
}