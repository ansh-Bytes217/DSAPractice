import java.util.Scanner;

public class MaxHeapInsertion {

    // Helper method to swap two elements in the array
    private static void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Method to insert a value into the Max-Heap
    private static int insertMaxHeap(int[] heap, int size, int capacity, int value) {
        // Check if the heap is already full
        if (size >= capacity) {
            System.out.println("Heap Overflow! Cannot insert " + value);
            return size;
        }

        // Step 1: Insert the new element at the end of the heap
        heap[size] = value;
        int i = size;
        size++; // Increase the size of the heap

        // Step 2: Heapify-up (Bubble up)
        // Loop runs as long as we aren't at the root and the current node is greater than its parent
        while (i != 0 && heap[i] > heap[(i - 1) / 2]) {
            swap(heap, i, (i - 1) / 2); // Swap with parent
            i = (i - 1) / 2;            // Move up to the parent's index
        }

        return size; // Return the updated size
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter maximum capacity of the heap: ");
        int capacity = scanner.nextInt();
        int[] heap = new int[capacity];
        int size = 0;

        System.out.print("Enter the number of initial elements to insert: ");
        int n = scanner.nextInt();

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            size = insertMaxHeap(heap, size, capacity, value);
        }

        // Display the heap array after initial insertions
        System.out.print("Max Heap array representation: ");
        printHeap(heap, size);

        System.out.print("\nEnter a new element to insert: ");
        int newElement = scanner.nextInt();
        size = insertMaxHeap(heap, size, capacity, newElement);

        System.out.print("Max Heap array after inserting " + newElement + ": ");
        printHeap(heap, size);

        scanner.close();
    }

    private static void printHeap(int[] heap, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i]);
            if (i != size - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
