/**
 * LC 1272: https://leetcode.com/problems/remove-interval/
 * Given a sorted list of disjoint intervals, 
 * each interval intervals[i] = [a, b] represents the set of real numbers x such that a <= x < b.
 * We remove the intersections between any interval in intervals and the interval toBeRemoved.
 * Return a sorted list of intervals after all such removals.
 * 
*/

/**
 * 思路：看interval slot和toBeRemove 有没有交集
 * （1）没有交集直接加进去
 *  (2)有交集：
 *         -------
 *      ---|---
 *           ---
 *              --|----
 *       --|------|-----
*/
import java.util.*;
public class RemoveIntervals {

    //Time: O(n) Space: O(1)
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        int start = toBeRemoved[0];
        int end = toBeRemoved[1];
        List<List<Integer>> ans = new ArrayList<>();
        for(int[] slot : intervals){
            if(slot[1] <= start || slot[0] >= end){ // 没有交集
                List<Integer> interval = new ArrayList<>();
                interval.add(slot[0]);
                interval.add(slot[1]);
                ans.add(interval); 
            }
            else{              
                if(slot[0] < start){ 
                    List<Integer> interval = new ArrayList<>();
                    interval.add(slot[0]);
                    interval.add(start);
                    ans.add(interval);
                }
                if(end < slot[1]){
                    List<Integer> interval = new ArrayList<>();
                    interval.add(end);
                    interval.add(slot[1]);  
                    ans.add(interval);
                }
            }
        }
        return ans;
    }
}
