import java.util.ArrayList;

class myStack {
    ArrayList<Integer> arr = new ArrayList<>();

    // push operation
    void push(int x) {
        arr.add(x);
    }

    // pop operation
    int pop() {
        if (arr.isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int val = arr.get(arr.size() - 1);
        arr.remove(arr.size() - 1);
        return val;
    }

    // peek operation
    int peek() {
        if (arr.isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return arr.get(arr.size() - 1);
    }

    // check if stack is empty
    boolean isEmpty() {
        return arr.isEmpty();
    }

    // current size
    int size() {
        return arr.size();
    }

    public static void main(String[] args) {
        myStack st = new myStack();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++){
            st.push(i);
        }
        // popping one element
        System.out.println("Popped: " + st.pop());

        // checking top element
        System.out.println("Top element: " + st.peek());

        // checking if stack is empty
        System.out.println("Is stack empty: " + 
                            (st.isEmpty() ? "Yes" : "No"));

        // checking current size
        System.out.println("Current size: " + st.size());
    }
}
