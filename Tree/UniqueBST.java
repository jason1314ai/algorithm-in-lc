/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 // 左边是小于n组成的， 右边是大于n组成的，分治的思想
class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ls =new ArrayList<>();
        if(n < 1)
            return ls;
        return helper(1,n);
       
    }
    public List<TreeNode> helper(int start, int end){
        List<TreeNode> ls =new ArrayList<>();
        if(start>end){
            ls.add(null);
            return ls;
        }
        if(start == end){
            ls.add(new TreeNode(start));
            return ls;
        }
        for(int i =start;i<=end;i++){
            List<TreeNode> l1 = helper(i+1,end);
            List<TreeNode> l2 = helper(start,i-1);
            for(int j = 0;j<l1.size();j++){
                for(int m = 0;m<l2.size();m++){
                    TreeNode n = new TreeNode(i);
                    n.left = l2.get(m);
                    n.right = l1.get(j);
                    ls.add(n);
                }
            }
        }
        return ls;
    }
}
