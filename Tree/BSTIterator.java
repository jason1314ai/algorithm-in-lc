class BSTIterator {
    Stack<TreeNode> st = new Stack<>();
    public BSTIterator(TreeNode root) {
        TreeNode p =  root;
        while(p != null){
            st.push(p);
            p = p.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode n  = st.pop();
        TreeNode p = n.right;
        while(p != null){
            st.push(p);
            p = p.left;
        }
        return n.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }
}