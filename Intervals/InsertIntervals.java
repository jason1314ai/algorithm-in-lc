/**
 * LC 57: https://leetcode.com/problems/insert-interval/
 * Given a set of non-overlapping intervals
 * insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
*/

/**
 * 思路：
 * Build 一个需要插入的interval(start, end)， 不断更新start和end
 * 注意最后需要检查是否已经插入
*/
import java.util.*;

public class InsertIntervals {

    // Time: O(n) Space: O(1) if not count list
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ls = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        for(int[] slot : intervals){
            if(start == -1 || slot[1] < start){
                ls.add(slot);
            }else if(slot[0] > end){
                ls.add(new int[]{start,end});
                ls.add(slot);
                start = -1;
            }else{
                start =  Math.min(slot[0],start);
                end = Math.max(slot[1],end);
            }
        }
        if(start != -1){ // Has not been inserted 类似merge，都要注意对最后一个的处理
            ls.add(new int[]{start, end});
        }
        int[][] ans = new int[ls.size()][2];
        for(int i = 0;i< ans.length;i++){
            ans[i] = ls.get(i);
        }
        return ans;
    }    
}
