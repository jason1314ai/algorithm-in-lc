/**
 * Inorder 遍历计数
 * 如果和pre相等 则count++
 * 
*/

import java.util.*;

class FindModeBST {
    TreeNode pre;
    int max = 0;
    int count = 0;
    public int[] findMode(TreeNode root) {
        List<Integer> ls =new ArrayList<>();
        traverse(root, ls);
        int[] arr = new int[ls.size()];
        for(int i =0;i<ls.size();i++){
            arr[i] = ls.get(i);
        }
        return arr;
    }
    
    void traverse(TreeNode root, List<Integer> ls){
        if(root == null){
            return;
        }
        traverse(root.left,ls);
        
        if(pre == null || pre.val != root.val){
            count = 1;
        }else{
            count++;
        }
        
        //check number of root.val with max
        if(count > max){
            ls.clear();
            ls.add(root.val);
            max = count;
        }else if(count == max){
            ls.add(root.val);
        }
        
        pre = root;
        traverse(root.right,ls); 
    }
}
