class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int[] arr = new int[2];
        while(start+1 < end){
            int mid = (end-start)/2+start;
            if(nums[mid] >= target){
                end = mid;
            }
            if(nums[mid] < target){
                start = mid + 1;
            }
        }

        if(nums[start] == target)
            arr[0] = start;
        else if (nums[end] == target)
            arr[0] = end;
        else
            return new int[]{-1,-1};

        start = 0;
        end = nums.length -1;
        while(start + 1<end){
            mid = (end - start)/2 +start;
            if(nums[mid] <= target)
                start = mid;
            else
                end = mid -1;
        }
        if(nums[end] == target)
            arr[1] = end;
        else if(nums[start] == target)
            arr[1] = start;
        else
            return new int[]{-1,-1};

    }
}
