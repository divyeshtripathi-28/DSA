class Solution {
    public boolean canJump(int[] nums) {
        int maxJump = nums[0];
        maxJump--;

        for(int i = 1; i < nums.length; i++) {
            if(maxJump < 0) {
                return false;
            }

            if(nums[i] > maxJump) {
                maxJump = nums[i];
            }

            maxJump--;
        }

        return true;
    }
}