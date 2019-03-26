/**
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.
*/


class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length ==0)
            return -1;
        int start = 0;
        int end = nums.length -1;
        while(start + 1<end){
            int mid = (end-start)/2 + start;
            if(nums[mid] < nums[mid -1])
                return nums[mid];
            else if(nums[mid]>nums[end])
                start = mid;
            else 
                end = mid;

        }
        return Math.min(nums[start],nums[end]);
    }
}
