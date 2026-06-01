import java.util.*;
import java.util.Stack;

public static int[] monotonicStack(int[] nums){
  int n = nums.length;
  int[] result = new int[n];

  Stack<Integer> stack = new Stack<>(); //Initialise an empty stack
  
//loop through the array elements
for(int i =0; i < n; i++){
  //while stack is not Empty and current element violates the monotonic property
  while(!stack.isEmpty() && violatesMonotonicProperty(nums[stack.peek()],nums[i])){
    int idx = stack.pop(); //resmoves the top element(process it)
    result[idx] = i; //main logic determination
  }

  stack.push(i);
}

return result;
}
