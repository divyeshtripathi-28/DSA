class Solution {
    public int removeElement(int[] nums, int val) {
        int re = 0;
        for(int i=0; i<=nums.length-1; i++){
            if(nums[i] != val){
                nums[re]=nums[i];
                re++;
            }
        }
        return re;
    }
}