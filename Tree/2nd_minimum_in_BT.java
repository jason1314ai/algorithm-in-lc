/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 /*
（1）如果根结点或者左右都为空，则不存在；
 (2) 如果左子节点等于root，右子节点不等， 则求Math.min(f(left) == -1,则返回右,right);
 (3) 如果右子节点等于root, 左子节点不等， 则求Math.min(f(right) == -1则返回左,left);
 (4) 都等于的情况下，求Math.min(f(left),f(right) 看谁为-1);
 */
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
       if(root == null)
           return -1;
        if(root.left == null && root.right == null)
            return -1;
        int left = root.left.val;
        int right = root.right.val;
        if(left == root.val){
            left = findSecondMinimumValue(root.left);
        }
        if(right == root.val){
            right = findSecondMinimumValue(root.right);
        }
        if(right == -1 && left == -1)
            return -1;
        else if(right == -1)
            return left;
        else if(left == -1)
            return right;
        else
            return Math.min(left,right);
    }
}
