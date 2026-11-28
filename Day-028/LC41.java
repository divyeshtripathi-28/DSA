class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        int n = nums.length;

        while(i < n) {
            int idx = nums[i] - 1;

            if(nums[i] >= 1 && nums[i] <= n && nums[i] != nums[idx]) {
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
            } else {
                i++;
            }
        }

        for(int j = 0; j < nums.length; j++) {
            if(nums[j] != j + 1) {
                return j + 1;
            }
        }

        return n + 1;
    }
}