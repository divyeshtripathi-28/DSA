class Solution {
    public int searchInsert(int[] nums, int target) {
        int si = 0, ei = nums.length - 1;
        if(target>nums[nums.length - 1]){
            return nums.length;
        }
        else if(target<nums[0]){
            return 0;
        }


        else if(target >= nums[0] && target <= nums[nums.length -1]) {

            while(si <= ei){
                int mid = si + (ei - si)/2;
                if(nums[mid] == target){
                    return mid;
                }

                if(si+1 == ei){
                    return si + 1;
                }

                if(nums[mid] < target){
                    si = mid;
                }

                if(nums[mid] > target){
                    ei = mid;
                }
            }
        }
        
        return -1;
    }
}