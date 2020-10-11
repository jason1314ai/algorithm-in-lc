/**
 * LC:436
 * https://leetcode.com/problems/find-right-interval/
 * 
 * You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.
 * The right interval for an interval i is an interval j such that startj >= endi and startj is minimized.
 * Return an array of right interval indices for each interval i. 
 * If no right interval exists for interval i, then put -1 at index i. 
 * 
*/

/**
 * 思路：
 * 把start end分别排序，然后two pointers遍历
 * 
*/
import java.util.*;
public class FindRightInterval {

    //Time: O(nlogn + n)   Space:O(n)
    public int[] findRightInterval(int[][] intervals) {
        int[][] end = new int[intervals.length][2];
        int[][] start = new int[intervals.length][2];
        for(int i = 0;i<intervals.length;i++){
            end[i][0] = intervals[i][1];
            end[i][1] = i;
            start[i][0] = intervals[i][0];
            start[i][1] = i;
        }
        Arrays.sort(end,(a,b)->a[0]-b[0]);
        Arrays.sort(start,(a,b)->a[0]-b[0]);
        int p1 = 0;
        int p2 = 0;
        int[] ans = new int[intervals.length];
        Arrays.fill(ans,-1);
        while(p1 < start.length){
            if(start[p1][0] < end[p2][0]){
                p1++;
            }else{
                ans[end[p2][1]] = start[p1][1];   
                p2++;
            }
        }
        return ans;
    }
}
