import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {

    // Max-Heap to store the lower half of numbers
    private static PriorityQueue<Integer> lowerHalf = new PriorityQueue<>(Collections.reverseOrder());
    // Min-Heap to store the upper half of numbers
    private static PriorityQueue<Integer> upperHalf = new PriorityQueue<>();

    // Method to add a number to the stream
    public static void addNumber(int num) {
        // Step 1: Insert into the appropriate heap
        if (lowerHalf.isEmpty() || num <= lowerHalf.peek()) {
            lowerHalf.add(num);
        } else {
            upperHalf.add(num);
        }

        // Step 2: Balance the heaps if size difference > 1
        if (lowerHalf.size() > upperHalf.size() + 1) {
            upperHalf.add(lowerHalf.poll());
        } else if (upperHalf.size() > lowerHalf.size() + 1) {
            lowerHalf.add(upperHalf.poll());
        }
    }

    // Method to find and return the current median
    public static double getMedian() {
        if (lowerHalf.size() == upperHalf.size()) {
            // Even number of elements: average of the two roots
            return (lowerHalf.peek() + upperHalf.peek()) / 2.0;
        } else if (lowerHalf.size() > upperHalf.size()) {
            // Odd number of elements: root of the larger heap
            return lowerHalf.peek();
        } else {
            return upperHalf.peek();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter numbers one by one (type any non-integer to stop):");
        
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            addNumber(num);
            
            // Format output to remove trailing zeroes if it's a whole number
            double median = getMedian();
            if (median % 1 == 0) {
                System.out.printf("Current Median: %.0f\n", median);
            } else {
                System.out.printf("Current Median: %.1f\n", median);
            }
        }
        
        scanner.close();
    }
}
