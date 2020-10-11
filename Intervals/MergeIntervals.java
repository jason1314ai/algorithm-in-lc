/**
 * LC 56: https://leetcode.com/problems/merge-intervals/
 * Given a collection of intervals, merge all overlapping intervals.
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * 
*/

/**
 * 思路：
 * Build 一个需要merge的interval(start, end)， 不断更新start/end，没有交集的时候插入
 * 注意最后需要检查是否已经插入
*/

import java.util.*;
public class MergeIntervals {

    //Time: O(nlogn + n) Space: O(1) if not count list;
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        int start = -1;
        int end = -1;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        for(int i = 0;i<intervals.length;i++){
            if(start == -1){
                start = intervals[i][0];
                end = intervals[i][1];
            }else if(intervals[i][0] <= end){
                end = Math.max(intervals[i][1],end);
            }else{
                ans.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
            if(i == intervals.length-1){ // 注意最后一个要被加进去
                ans.add(new int[]{start,end});
            }
        }
        int[][] arr = new int[ans.size()][2];
        for(int i = 0;i< arr.length;i++)
            arr[i] = ans.get(i);
        return arr;
    }
}
