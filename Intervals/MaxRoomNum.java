/**
 * LC 252 & LC 253 : https://leetcode.com/problems/meeting-rooms-ii/
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei)
 * find the minimum number of conference rooms required.
*/

/**
 * 三种方法：
 *（1） 因为最多的时间点一定是某个起始点，所以可以用扫描线扫描所有起始点 
 *（2） 末尾点可以用minheap(priorityqueue)进行优化
 *（3） * * * # * #  : 双数组排序
 *     |         |
 *    start     end
*/

import java.util.*;

class MaxRoomNum {

    // Brute force
    // Time: o(n^2) Space: o(1)
    public int minMeetingRooms1(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int max = 0;
        for(int i = 0;i<intervals.length;i++){
            int time = intervals[i][0];
            int count = 0;
            for(int j = 0;j <= i;j++){    //如果一开始不排序则需要遍历所有 且比较起始和末尾
                if(time < intervals[j][1])
                    count++;
            }
            max = Math.max(count,max);
        }
        return max;
    }

    // MinHeap
    // Time: o(nlogn) Space: o(n)
    public int minMeetingRooms2(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int max = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int i = 0;i<intervals.length;i++){
            int time = intervals[i][0];
            queue.offer(intervals[i][1]); // o(logn)
            while(!queue.isEmpty() && queue.peek() <= time){  // 如果end小于等于time，该interval结束
                queue.poll(); //average time cost o(1) 
            }
            max = Math.max(queue.size(),max); 
        }
        return max;
    }

    // Two Pointers
    // Time: o(nlogn + n) Space: o(n)
    public int minMeetingRooms3(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i = 0;i<intervals.length;i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int max = 0;     
        int p1 = 0, p2 = 0;
        while(p1 < start.length){
            if(start[p1] < end[p2]){
                p1++;   
                max = Math.max(p1-p2,max);
            }else{
                p2++;
            }
        }
        return max;
    }

    // Check whether need extra meeting room
    public boolean canAttendMeetings(int[][] intervals) {
        Comparator<int[]> myCom = new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        };
        Arrays.sort(intervals,myCom);
        for(int i = 0;i<intervals.length-1;i++){
            if(intervals[i][1] > intervals[i+1][0])
                return false;
        }
        return true;
    }

}