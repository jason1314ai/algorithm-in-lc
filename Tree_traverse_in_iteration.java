// inorder

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur;
        TreeNode pre = null;
        if(root == null) return ls;
        stack.push(root);
        while(!stack.isEmpty()){
            cur = stack.peek();
            if(pre == null || pre.left == cur || pre.right == cur){
                if(cur.left != null)
                    stack.push(cur.left);
                else{
                    ls.add(cur.val);
                    stack.pop();
                    if(cur.right != null)
                        stack.push(cur.right);
                }
            }
            else{
                ls.add(cur.val);
                stack.pop();
                if(cur.right != null){
                    stack.push(cur.right);
                }
            }
            pre = cur;
        }
        return ls;
    }
}

// preorder
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur;
        TreeNode pre = null;
        if(root == null) return ls;
        stack.push(root);
        while(!stack.isEmpty()){
            cur = stack.peek();
            if(pre == null || pre.left == cur || pre.right == cur){
                ls.add(cur.val);
                if(cur.left != null)
                    stack.push(cur.left);
                else if(cur.right != null)
                    stack.push(cur.right);
            }
            else if(cur.left == pre){
                if(cur.right != null)
                    stack.push(cur.right);
            }
            else{
                stack.pop();
            }
            pre = cur;
        }
        return ls;
    }
}

//postorder

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ls =new ArrayList<>();
        Stack<TreeNode> stack =  new Stack<>();
        if(root == null) return ls;
        stack.push(root);
        TreeNode cur;
        TreeNode pre = null;
        while(!stack.isEmpty()){
            cur = stack.peek();
            if(pre == null || pre.left == cur || pre.right == cur){
                if(cur.left != null)
                    stack.push(cur.left);
                else if(cur.right != null)
                    stack.push(cur.right);
            }
            else if(cur.left == pre){
                if(cur.right != null)
                    stack.push(cur.right);
            }
            else{
                ls.add(cur.val);
                stack.pop();
            }
            pre = cur;
        }
        return ls;
    }
}
