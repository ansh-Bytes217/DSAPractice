import java.util.Scanner;

public class MaxHeapDelete {

    private static void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private static int insertMaxHeap(int[] heap, int size, int value) {
        heap[size] = value;
        int i = size;
        size++;

        while (i != 0 && heap[i] > heap[(i - 1) / 2]) {
            swap(heap, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
        return size; 
    }

    // Method to delete the root from the Max-Heap
    private static int deleteRoot(int[] heap, int size) {
        if (size <= 0) {
            System.out.println("Heap is empty!");
            return 0;
        }

        // Step 1: Replace root with the last element
        heap[0] = heap[size - 1];
        
        // Step 2: Reduce heap size
        size--;

        // Step 3: Heapify down
        int i = 0;
        while (true) {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;
            int largest = i;

            // Check if left child is larger than current element
            if (leftChild < size && heap[leftChild] > heap[largest]) {
                largest = leftChild;
            }

            // Check if right child is larger than the largest so far
            if (rightChild < size && heap[rightChild] > heap[largest]) {
                largest = rightChild;
            }

            // If the largest is still the current element, max-heap property is satisfied
            if (largest == i) {
                break;
            }

            // Swap with the larger child and update index
            swap(heap, i, largest);
            i = largest;
        }

        return size;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] heap = new int[n];
            int size = 0;

            for (int i = 0; i < n; i++) {
                if (scanner.hasNextInt()) {
                    int value = scanner.nextInt();
                    size = insertMaxHeap(heap, size, value);
                }
            }

            // Delete the root element
            size = deleteRoot(heap, size);

            // Print the heap after deletion
            for (int i = 0; i < size; i++) {
                System.out.print(heap[i]);
                if (i != size - 1) {
                    System.out.print(" ");
                }
            }
        }
        scanner.close();
    }
}
