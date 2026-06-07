public class MaxHeapHandling {

    private static void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static int deleteRoot(int[] heap, int size) {
        if (size <= 0) {
            System.out.println("Heap is empty!");
            return 0;
        }

        // Step 1: Replace root with the last element
        heap[0] = heap[size - 1];
        
        // Step 2: Reduce heap size
        size--;

        // Step 3: Max-Heapify Down
        int i = 0;
        while (true) {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;
            int largest = i;

            // Is left child larger than the current largest?
            if (leftChild < size && heap[leftChild] > heap[largest]) {
                largest = leftChild;
            }

            // Is right child larger than the current largest?
            if (rightChild < size && heap[rightChild] > heap[largest]) {
                largest = rightChild;
            }

            // If the parent is still the largest, we are done
            if (largest == i) {
                break;
            }

            // Otherwise, swap and continue down the tree
            swap(heap, i, largest);
            i = largest; 
        }

        return size; // Return the new size of the heap
    }
}
