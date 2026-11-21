class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length < 4) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 3; i++) {
            for(int j = i + 1; j < nums.length - 2; j++) {

                int p = j + 1;
                int q = nums.length - 1;
                long req = (long) target - (nums[i] + nums[j]);

                while(p < q) {
                    if((long)nums[p] + nums[q] == req) {
                        List<Integer> arr = new ArrayList<>();
                        arr.add(nums[i]);
                        arr.add(nums[j]);
                        arr.add(nums[p]);
                        arr.add(nums[q]);

                        set.add(arr);
                        p++;
                        q--;
                    } else if((long)nums[p] + nums[q] < req) {
                        p++;
                    } else {
                        q--;
                    }
                }
            }
        }

        for(List<Integer> val : set) {
            list.add(val);
        }

        return list;
    }
}