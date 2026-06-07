import java.util.Scanner;

public class MaxHeap {

    private static void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Method to insert a value into the Max-Heap
    private static int insertMaxHeap(int[] heap, int size, int value) {
        heap[size] = value;
        int i = size;
        size++;

        // Changed from '<' to '>' so larger elements move up to the root
        while (i != 0 && heap[i] > heap[(i - 1) / 2]) {
            swap(heap, i, (i - 1) / 2);
            i = (i - 1) / 2;
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

            // Print the heap elements
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
