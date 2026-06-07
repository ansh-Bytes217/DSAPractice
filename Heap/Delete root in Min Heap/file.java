import java.util.Scanner;

public class MinHeapDelete {

    private static void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private static int insertMinHeap(int[] heap, int size, int value) {
        heap[size] = value;
        int i = size;
        size++;

        while (i != 0 && heap[i] < heap[(i - 1) / 2]) {
            swap(heap, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
        return size; 
    }

    // Method to delete the root from the Min-Heap
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
            int smallest = i;

            // Check if left child is smaller than current element
            if (leftChild < size && heap[leftChild] < heap[smallest]) {
                smallest = leftChild;
            }

            // Check if right child is smaller than the smallest so far
            if (rightChild < size && heap[rightChild] < heap[smallest]) {
                smallest = rightChild;
            }

            // If the smallest is still the current element, the heap property is restored
            if (smallest == i) {
                break;
            }

            // Swap with the smaller child and update index
            swap(heap, i, smallest);
            i = smallest;
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
                    size = insertMinHeap(heap, size, value);
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
