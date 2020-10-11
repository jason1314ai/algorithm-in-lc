/**
 * 遍历
 * 
*/

import java.util.*;

class FindModeBST {
    TreeNode pre = null;
    int max = 0;
    int count = 1;
    public int[] findMode(TreeNode root) {
        List<Integer> ls =new ArrayList<>();
        traverse(root, ls);
        int[] arr = new int[ls.size()];
        for(int i =0;i<ls.size();i++){
            arr[i] = ls.get(i);
        }
        return arr;
    }
    
    public void traverse(TreeNode root, List<Integer> ls){
        if(root == null) return;
        traverse(root.left,ls);
        if(pre != null){
            if(pre.val == root.val)
                count++;
            else{
                count = 1;
            }
        }
        if(count == max){
            ls.add(root.val);
        }
        
        if(count > max){
            ls.clear();
            ls.add(root.val);
            max = count;
        }
        pre = root;
        traverse(root.right,ls);
    }
}
