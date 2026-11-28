class Solution {
    public void subset(int[] nums, List<Integer> arr, HashSet<List<Integer>> set, int start) {
        set.add(new ArrayList<>(arr));

        for(int i = start; i < nums.length; i++) {
            arr.add(nums[i]);
            subset(nums, arr, set, i + 1);
            arr.remove(arr.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        subset(nums, new ArrayList<>(), set, 0);

        while(!set.isEmpty()) {
            List<Integer> element = set.iterator().next();
            list.add(element);
            set.remove(element);
        }

        return list;
    }
}