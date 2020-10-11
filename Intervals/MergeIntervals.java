/**
 * 扫描线
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
