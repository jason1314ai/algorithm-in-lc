/**
 * LC 1288
 * https://leetcode.com/problems/remove-covered-intervals/
 * 
 * Given a list of intervals, remove all intervals that are covered by another interval in the list.
 * Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.
 * After doing so, return the number of remaining intervals.
 * 
*/

/**
 * 思路：
 * 
 * a. 按照start排序,如果start相等，end大的靠前；
 * b. 因为前面的一定能cover起始点，只用考虑end；
 * 
*/
import java.util.*;

public class RemoveCoveredInterval {
    public int removeCoveredIntervals(int[][] intervals) {
        int count = intervals.length;
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] != b[0])
                    return a[0] - b[0];
                else
                    return b[1] - a[1];
            }
        });
        int end = -1;
        for(int i = 0;i<intervals.length;i++){
            if(end >= intervals[i][1]){
                count--;
            }   
            end = Math.max(intervals[i][1],end);
        }
        return count;
    }
}
