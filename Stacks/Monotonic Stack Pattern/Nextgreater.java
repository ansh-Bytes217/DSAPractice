import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public int[] nextGreater(int[] nums){
  n = nums.length;
  int[] res = new int[n];
  Arrays.fill(res,-1);

  Deque<Integer> stack = new ArrayDeque<>();

  for(int i = 0; i < nums.length; i++){
    while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
      res[stack.pop()] = nums[i];
    }
    stack.push();
  }
  return res;
}
