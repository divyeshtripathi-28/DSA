class Solution {
    public void nextPermutation(int[] nums) {
        int i = 0;
        for(i = nums.length - 1; i > 0; i--) {
            if(nums[i] > nums[i - 1]) {
                break;
            }
        }

        if(i == 0) {
            Arrays.sort(nums);
            return;
        }

        i--;

        int k = nums.length - 1;

        while(nums[k] <= nums[i]) {
            k--;
        }

        
        nums[i] = nums[i] + nums[k];
        nums[k] = nums[i] - nums[k];
        nums[i] = nums[i] - nums[k];
        i++;

        for(; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] > nums[j]) {
                    nums[i] = nums[i] + nums[j];
                    nums[j] = nums[i] - nums[j];
                    nums[i] = nums[i] - nums[j];
                }
            }
        }
    }
}