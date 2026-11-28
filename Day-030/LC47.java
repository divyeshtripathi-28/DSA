class Solution {
    public void permutation(int[] nums, List<Integer> arr, HashSet<List<Integer>> set,HashSet<Integer> set2) {
        if(arr.size() == nums.length) {
            set.add(new ArrayList<>(arr));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(set2.contains(i)) {
                continue;
            }
            set2.add(i);
            arr.add(nums[i]);
            permutation(nums, arr, set, set2);
            set2.remove(i);
            arr.remove(arr.size() - 1);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        List<List<Integer>> list = new LinkedList<>();

        permutation(nums, new ArrayList<>(), set, new HashSet<>());

        while(!set.isEmpty()) {
            List<Integer> element = set.iterator().next();
            list.add(element);
            set.remove(element);
        }
        return list;
    }
}