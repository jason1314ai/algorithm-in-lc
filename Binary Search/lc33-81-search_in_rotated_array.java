/**
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

// no duplicate
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0 )
            return -1;
        int start = 0;
        int end = nums.length -1;
        while(start + 1 < end){
            int mid = (end-start)/2 + start;
            if(nums[mid] == target)
                return mid;
            if(nums[mid]>nums[end]){
                    if(nums[mid]>target){
                        if(nums[end] >= target)
                            start = mid +1;
                        else
                            end = mid -1;
                    }else{
                        start = mid +1;
                    }
                }
            else{
                if(nums[mid] < target){
                    if(nums[end] >= target)
                        start = mid +1;
                    else
                        end  = mid -1;
                }
                else{
                    end = mid -1;
                }
            }
        }
        if(nums[start] == target)
            return start;
        if(nums[end] == target)
            return end;
        return -1;
        
    }
}


// duplicate
class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return false;
        int start = 0;
        int end = nums.length-1;
        while(start+1 < end){
            int mid = (end- start)/2 + start;
            if(nums[mid] == target)
                return true;
           if(nums[mid] == nums[end] && nums[mid] == nums[start])
               end --;
            else if(nums[mid] == nums[start])
                start = mid + 1;
            else if(nums[mid] == nums[end])
                end = mid -1;
            else if(nums[end] > nums[mid]){
                if(target <= nums[end]){
                    if(target > nums[mid])
                        start = mid;
                    else
                        end = mid;
                }
                else
                    end = mid;
            }
            else if(nums[mid] > nums[end]){
                if(target <= nums[end])
                    start = mid;
                else{
                    if(nums[mid]>target)
                        end = mid;
                    else
                        start = mid;
                }
            }
        }
        if(nums[start] != target && nums[end] != target)
            return false;
        return true;
    }
}
