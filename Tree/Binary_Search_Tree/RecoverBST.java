
/*
将函数中序遍历一遍，找到第一个不满足要求的数，和最后一个不满足要求的数，然后交换。
*/
class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode firstelement = null;
        TreeNode secelement = null;
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
        inorder(root,firstelement, secelement,pre);
        if(firstelement != null && secelement != null){
            int temp = firstelement.val;
            firstelement.val = secelement.val;
            secelement.val = temp;
        }
    }
    
    
    public void inorder(TreeNode root, TreeNode firstelement, TreeNode secelement, TreeNode pre){
        if(root == null)
            return;
        inorder(root.left, firstelement, secelement, pre);
        if(firstelement == null && pre.val > root.val)
            firstelement = pre;
        if(firstelement != null && pre.val > root.val)
            secelement = root;
        pre = root;
        inorder(root.right,firstelement, secelement, pre);
    }
}
