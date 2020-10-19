/**
 * LC 912: https://leetcode.com/problems/sort-an-array/
 * 
 * sort后相邻的merge
 * --------------------------------------------------
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n) -> array  O(1) -> LinkedList
*/
import java.util.*;
public class MergeSort{
    public void mergeSort(int[] arr){
        sort(arr,0,arr.length-1);
    }
    private void sort(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        int mid = (end - start)/2 + start;
        sort(arr,start,mid);
        sort(arr,mid+1,end);
        merge(arr,start,mid,end);
    }

    private void merge(int[] arr, int start, int mid, int end){
        int[] ans = new int[end-start+1];
        int p1 = start;
        int p2 = mid+1;
        int index = 0;
        while(p1 <= mid && p2 <= end){
            if(arr[p1] < arr[p2]){
                ans[index] = arr[p1];
                p1++;
            }else{
                ans[index] = arr[p2];
                p2++;
            }
            index++;
        }
        while(p1 <= mid){
            ans[index] = arr[p1];
            index++;
            p1++;
        }
        while(p2 <= end){
            ans[index] = arr[p2];
            p2++;
            index++;
        }
        for(int i = start;i<=end;i++)
            arr[i] = ans[i-start];
        return;
    }



}