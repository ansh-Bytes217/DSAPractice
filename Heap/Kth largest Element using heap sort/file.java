import java.util.Scanner;

public class KthLargestElement {

    private static void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Standard Min-Heapify Down operation
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

    // Standard Min-Heapify Up operation
    private static void heapifyUp(int[] heap, int i) {
        while (i != 0 && heap[i] < heap[(i - 1) / 2]) {
            swap(heap, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    // Method to find the Kth largest element
    private static int findKthLargest(int[] arr, int n, int k) {
        // Create a min-heap array of size k
        int[] minHeap = new int[k];
        int size = 0;

        // Step 1: Insert first k elements into the min-heap
        for (int i = 0; i < k; i++) {
            minHeap[size] = arr[i];
            heapifyUp(minHeap, size);
            size++;
        }

        // Step 2: Process remaining elements
        for (int i = k; i < n; i++) {
            // If the current element is larger than the smallest in our top-k group
            if (arr[i] > minHeap[0]) {
                minHeap[0] = arr[i]; // Replace root
                heapifyDown(minHeap, k, 0); // Restore min-heap property
            }
        }

        // Step 3: The root of the min-heap is now the Kth largest element
        return minHeap[0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            int k = scanner.nextInt();

            // Corner case validation
            if (k > 0 && k <= n) {
                int result = findKthLargest(arr, n, k);
                System.out.println(result);
            } else {
                System.out.println("Invalid value of K");
            }
        }
        scanner.close();
    }
}
