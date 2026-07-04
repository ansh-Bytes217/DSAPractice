import java.util.*;

public class Solution{
  public boolean isSame(TreeNode p,TreeNode q){
    if(p == null && q == null) return true;
    if(p == null || q == null) return false;

    return(p.val == q.val) && isSame(p.left == q.left) && isSame(p.right == q.right);
  }
}

/*Intuition
the both trees are same under conditions:
if both of them are null on left and right side
or if values across left subtree is similar to values accross right subtree*/
