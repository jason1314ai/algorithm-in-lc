/**
    Implementation of tree traversal in Recursion, Stack and Morris traversal
*/


// Inorder
// Stack
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
            if(pre == null || pre.left == cur || pre.right == cur){ // 往下
                if(cur.left != null)
                    stack.push(cur.left);
                else{
                    ls.add(cur.val);
                    stack.pop();
                    if(cur.right != null)
                        stack.push(cur.right);
                }
            }
            else{  // 往上
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

/**
Bottom-up in two directions:

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        stack.push(root);
        TreeNode pre = null;
        TreeNode cur;
        while(!stack.isEmpty()){
            cur = stack.peek();
            if(pre == null || pre.left == cur || pre.right == cur){
                if(cur.left != null){
                    stack.push(cur.left);
                }else{
                    ans.add(cur.val);
                    if(cur.right != null){
                        stack.push(cur.right);
                    }else{
                        stack.pop();
                    }
                } 
            }else if(pre == cur.left){
                ans.add(cur.val);
                if(cur.right != null){
                    stack.push(cur.right);
                }else{
                    stack.pop();
                }
            }else{
                stack.pop();
            }
            pre = cur;
        }
        return ans;
    }
}
*/

//Morris Traversal
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode cur = root;
        List<Integer> ls = new ArrayList<>();
        while(cur != null){
            if(cur.left == null){
                ls.add(cur.val);
                cur = cur.right;
            }
            else{
                // find predecessor of current
                TreeNode p = cur.left;
                while(p.right != null && p.right != cur){
                    p = p.right;
                }
                if(p.right == null){    // 第一次访问
                    p.right = cur;
                    cur = cur.left;                    
                }else{                  // 第二次访问
                    p.right = null;
                    ls.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return ls;
    }
}

// Preorder
// Stack
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
            else if(cur.left == pre){ // 从左边上来
                if(cur.right != null)
                    stack.push(cur.right);
            }
            else{           //从右边上来
                stack.pop();
            }
            pre = cur;
        }
        return ls;
    }
}
//Morris
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode cur = root;
        List<Integer> ans = new ArrayList<Integer>();
        while(cur != null){
            ans.add(cur.val);
            if(cur.left == null){
                cur = cur.right;
            }else{
                TreeNode pre = cur.left;
                while(pre.right != null && pre.right != cur)
                     pre = pre.right; 
                if(pre.right == null){
                    pre.right = cur;
                    cur = cur.left;
                }else{
                    pre.right = null;
                    ans.remove(ans.size()-1); // 第二次访问要删除不能加
                    cur = cur.right;
                }
            }
        }
        return ans;
    }
}


//Postorder
//Stack
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

//Morris
/**
    类似 Morris in Preorder, 顺序为cur-右-左，然后list reverse过来
*/

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode cur = root;
        List<Integer> ans = new ArrayList<Integer>();
        while(cur != null){
            ans.add(0，cur.val);
            if(cur.right == null){
                cur = cur.left;
            }else{
                TreeNode pre = cur.right;
                while(pre.left != null && pre.left != cur)
                     pre = pre.left; 
                if(pre.left == null){
                    pre.left = cur;
                    cur = cur.right;
                }else{
                    pre.left = null;
                    ans.remove(0); // 第二次访问要删除不能加
                    cur = cur.left;
                }
            }
        }
        return ans;
    }
}    
