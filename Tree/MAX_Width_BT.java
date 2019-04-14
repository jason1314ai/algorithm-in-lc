/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> id = new LinkedList<>();
        queue.offer(root);
        id.offer(1);
        int max =0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int first = 0;
            int last = 0;
            for(int i =0;i<size;i++){
                TreeNode n = queue.poll();
                int i_d = id.poll();
                if(n.left != null){
                    queue.offer(n.left);
                    id.offer(i_d*2);
                }
                if(n.right != null){
                    queue.offer(n.right);
                    id.offer(i_d*2+1);
                }
                if(i == 0)
                    first = i_d;
                if(i == size-1)
                    last = i_d;
            }
            max =Math.max(max, last-first+1);
        }
        return max;
    }
}
