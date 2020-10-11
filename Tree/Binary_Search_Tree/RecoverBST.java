
/*
将函数中序遍历一遍，找到第一个不满足要求的数，和最后一个不满足要求的数，然后交换。
*/
class RecoverBST{
    TreeNode first = null;
    TreeNode second = null;
    public void recoverTree(TreeNode root) {
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
        inorder(root,pre);
        if(first != null && second != null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
    
    private void inorder(TreeNode root, TreeNode pre){
        if(root == null)
            return;
        inorder(root.left, pre);
        if(first == null && pre.val > root.val)
            first = pre;
        if(first != null && pre.val > root.val)
            second = root;
        pre = root;
        inorder(root.right, pre);
    }
}


/** 1 2 3 4 7 6 5 8  */


 