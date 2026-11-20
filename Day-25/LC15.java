class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList <>();
        HashSet<List<Integer>> set = new HashSet<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            int req = 0 - nums[i];

            while(j < k) {
                if(nums[j] + nums[k] == req) {
                    List<Integer> list1 = new ArrayList <>();
                    list1.add(nums[i]);
                    list1.add(nums[j]);
                    list1.add(nums[k]);

                    set.add(list1);
                    j++;
                    k--;
                } else if(nums[j] + nums[k] > req) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        list.addAll(set);

        return list;
    }
}