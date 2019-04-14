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
找寻左右子节点第一个不为根结点的数，再比较大小；
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
