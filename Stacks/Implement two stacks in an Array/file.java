import java.util.Arrays;

class twoStacks {
    int[] arr;
    int size;
    int top1, top2;

    twoStacks(int n)
    {
        size = n;
        arr = new int[n];
        Arrays.fill(arr, -1);
        
        // Stack1 starts from left (-1 means empty)
        top1 = -1;     
        
        // Stack2 starts from right (size means empty)
        top2 = size;
    }

    // Function to push element into Stack1
    void push1(int x)
    {
        // Check if there is space between two stacks
        if (top1 < top2 - 1) {
            
            // move top1 forward
            top1++;            
            arr[top1] = x;
        }
    }

    // Function to push element into Stack2
    void push2(int x)
    {
        // Check if there is space between two stacks
        if (top1 < top2 - 1) {
            
            // move top2 backward
            top2--;            
            arr[top2] = x;    
        }
    }

    // Function to pop element from Stack1
    int pop1()
    {
        // Check if Stack1 is empty
        if (top1 >= 0) {
            int x = arr[top1];
            top1--;
            return x;
        }
        else
            return -1;
    }

    // Function to pop element from Stack2
    int pop2()
    {
        // Check if Stack2 is empty
        if (top2 < size) {
            int x = arr[top2];
            top2++;
            return x;
        }
        else
            return -1;
    }
}

public class Main {
    public static void main(String[] args)
    {
        twoStacks ts = new twoStacks(5);
        ts.push1(2);
        ts.push1(3);
        ts.push2(4);

        System.out.print(ts.pop1() + " ");
        System.out.print(ts.pop2() + " ");
        System.out.print(ts.pop2() + " ");
    }
}
