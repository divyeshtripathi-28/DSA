class Solution {
    public void subset(int[] nums, List<Integer> arr, List<List<Integer>> list, int start) {
        list.add(new ArrayList<>(arr));

        for(int i = start; i < nums.length; i++) {
            arr.add(nums[i]);
            subset(nums, arr, list, i + 1);
            arr.remove(arr.size() - 1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        subset(nums, new ArrayList<>(), list, 0);

        return list;
    }
}