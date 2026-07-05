import java.util.*;

class Solution{
  int ans = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root){
    helper(root);
    reutrn ans;
  }

  int helper(TreeNode node){
    if(node == null) return 0;

    int left = Math.max(helper(root.left),0);
    int right = Math.max(helper(root.right),0);
    pathSum = node.val + left + right;

    ans = Math.max(ans,pathSum);
    return node.val + Math.max(left,right);
  }
}
