import java.util.Scanner;

public class MinHeapSort {

    private static void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Helper to push elements down and maintain Min-Heap property
    private static void heapifyDown(int[] heap, int size, int i) {
        while (true) {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;
            int smallest = i;

            if (leftChild < size && heap[leftChild] < heap[smallest]) {
                smallest = leftChild;
            }

            if (rightChild < size && heap[rightChild] < heap[smallest]) {
                smallest = rightChild;
            }

            if (smallest == i) {
                break;
            }

            swap(heap, i, smallest);
            i = smallest;
        }
    }

    // Converts an arbitrary array into a Min-Heap
    private static void buildMinHeap(int[] arr, int n) {
        // Start from the last non-leaf node and heapify down to the root
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapifyDown(arr, n, i);
        }
    }

    // Main Heap Sort method
    private static void heapSort(int[] arr, int n) {
        // Step 1: Build the min-heap
        buildMinHeap(arr, n);

        // Step 2: Extract elements one by one from the heap
        for (int i = n - 1; i > 0; i--) {
            // Swap current root (minimum) with the last element of the unsorted heap
            swap(arr, 0, i);

            // Call heapifyDown on the reduced heap to restore min-heap property
            heapifyDown(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                if (scanner.hasNextInt()) {
                    arr[i] = scanner.nextInt();
                }
            }

            // Run Heap Sort
            heapSort(arr, n);

            // Print the sorted array (will be in descending order)
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i]);
                if (i != n - 1) {
                    System.out.print(" ");
                }
            }
        }
        scanner.close();
    }
}
