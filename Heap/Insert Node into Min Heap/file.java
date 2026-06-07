import java.util.Scanner;

public class MinHeap {

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
