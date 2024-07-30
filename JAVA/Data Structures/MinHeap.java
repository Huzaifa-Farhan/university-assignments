public class MinHeap {
    private int[] heap;
    private int size;
    private int maxSize;

    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[this.maxSize];
    }

    //a
    private int parent(int i) { return (i - 1) / 2; }
    private int leftChild(int i) { return 2 * i + 1; }
    private int rightChild(int i) { return 2 * i + 2; }

    //c
    private void siftUp(int i) {
        while (i > 0 && heap[parent(i)] > heap[i]) {
            int temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = parent(i);
        }
    }

    //c
    private void siftDown(int i) {
        while (leftChild(i) < size) {
            int smallerChild = leftChild(i);
            if (rightChild(i) < size && heap[rightChild(i)] < heap[leftChild(i)]) {
                smallerChild = rightChild(i);
            }

            if (heap[i] <= heap[smallerChild]) {
                break;
            }

            int temp = heap[i];
            heap[i] = heap[smallerChild];
            heap[smallerChild] = temp;
            i = smallerChild;
        }
    }

    //d
    public void insert(int element) {
        if (size == maxSize) throw new IllegalStateException("Heap is full");
        heap[size] = element;
        siftUp(size);
        size++;
    }

    //i
    public int extractMin() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        int min = heap[0];
        heap[0] = heap[--size];
        siftDown(0);
        return min;
    }
    
    //i
    public int extractMax() {
        if (size == 0) throw new IllegalStateException("Heap is empty");

        // The maximum value could only be in the leaf nodes
        // Start checking from the last parent's child onwards
        int maxIndex = parent(size - 1) + 1;
        int maxValue = heap[maxIndex];

        // Find the maximum value among the leaf nodes
        for (int i = maxIndex + 1; i < size; i++) {
            if (heap[i] > maxValue) {
                maxValue = heap[i];
                maxIndex = i;
            }
        }

        // Swap the maximum value with the last element and remove it
        int temp = heap[maxIndex];
        heap[maxIndex] = heap[size - 1];
        heap[size - 1] = temp;
        size--;

        // Since we swapped, we might need to sift down the swapped element
        siftDown(maxIndex);

        return maxValue;
    }


    //j
    public void remove(int i) {
        if (i >= size) throw new IllegalArgumentException("Invalid index");
        heap[i] = Integer.MIN_VALUE;
        siftUp(i);
        extractMin();
    }

    public int getSize() { return size; }
    public int[] getHeap() { return heap; }
    public int peek() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        return heap[0];
    }
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        int[] elements = {16, 10, 14, 9, 7, 1, 4, 2, 8, 3};
        
        //insert being used here
        System.out.println("Inserting elements:");
        for (int element : elements) {
            minHeap.insert(element);
            System.out.println("Inserted " + element + ", Min now: " + minHeap.peek());
        }

        printHeap(minHeap);

//extracting the min and max values from the heap
//has sift up and sift down being used here
        
    int min = minHeap.extractMin();
    System.out.println("Extracted Min: " + min);
    printHeap(minHeap);
    
    int max = minHeap.extractMax();
    System.out.println("Extracted Max: " + max);
    printHeap(minHeap);


        
//adds everything back to the heap
    minHeap.insert(16);
    minHeap.insert(1);
    

 //remove method being used
 //heap also auto adjusts itself
    System.out.println("\nRemoving element at index 5 (Heap should adjust):");
    minHeap.remove(5);
    printHeap(minHeap);
    }

    
    //method to print the heap
    private static void printHeap(MinHeap minHeap) {
        System.out.print("Current Heap: ");
        for (int i = 0; i < minHeap.getSize(); i++) {
            System.out.print(minHeap.getHeap()[i] + " ");
        }
        System.out.println("\n");        
    }
}


