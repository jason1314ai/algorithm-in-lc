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
传递当前值
返回左右子树的结果
注意null的分析
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        return helper(root,0);
    }
    
    public int helper(TreeNode root, int sum){
        if(root.left == null && root.right == null)
            return sum*10 + root.val;
        if(root.left == null)
            return helper(root.right, sum*10 + root.val);
        if(root.right == null)
            return helper(root.left, sum*10 + root.val);
        return helper(root.left,sum*10 + root.val) + helper(root.right, sum*10 + root.val);
    }
}
