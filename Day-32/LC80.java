class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        int curr = nums[0];
        int count = 1;

        for(int j = 1; j < nums.length; j++) {
            if(curr == nums[j]) {
                if(count == 1) {
                    nums[i] = curr;
                    i++;
                    count++;
                } else {
                    continue;
                }
            } else {
                curr = nums[j];
                nums[i] = curr;
                i++;
                count = 1;
            }
        }

        return i;
    }
}