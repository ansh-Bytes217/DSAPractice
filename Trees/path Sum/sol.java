import java.util.*;

class Solution{
  public boolean pathSum(TreeNode root,int targetSum){
    if(root == 0) return 0;
    
    if(root.left  == root.right){
      return root.val == targetSum;
    }

    boolean left = pathSum(root.left,targetSum - node.val);
    boolean right = pathSum(root.right,targetSum - node.val);

    return left || right;
  }
}
