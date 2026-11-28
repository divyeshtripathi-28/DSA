class Solution {
    public void permutation(int[] nums, List<List<Integer>> list, List<Integer> arr) {
        if(nums.length == arr.size()) {
            list.add(new ArrayList<>(arr));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(arr.contains(nums[i])) {
                continue;
            }

            arr.add(nums[i]);
            permutation(nums, list, arr);
            arr.remove(arr.size() - 1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        permutation(nums, list, new ArrayList<>());

        return list;
    }
}