import java.util.*;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
}
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

/**
 * If add new function called prev to move pointer to the last node
 * 
 * 
 * class BSTIterator {
    List<Integer> pre = new ArrayList<>();
    int pointer = -1; // 指向当前访问的访问的元素

    Stack<TreeNode> stack = new Stack<>();
    
    public BSTIterator(TreeNode root) {
        TreeNode p = root;
        while(p != null){
            stack.push(p);
            p = p.left;
        }
    }
    
    public boolean hasNext() {
        return !stack.isEmpty() || pointer < pre.size()-1;
    }
    
    public int next() {
        if(pointer < pre.size()-1){
            pointer++;
            return pre.get(pointer);
        }
        TreeNode n = stack.pop();
        TreeNode p = n.right;
        while(p != null){
            stack.push(p);
            p = p.left;
        }
        pre.add(n.val);
        pointer++;
        return n.val;
    }
    
    public boolean hasPrev() {
        return pointer > 0;
    }
    
    public int prev() {
        pointer--;
        return pre.get(pointer);
    }
}
*/

