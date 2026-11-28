class Solution {
    public void backTrack(int[] candidates, int target, List<List<Integer>> list, List<Integer> arr, HashSet<List<Integer>> set, int start) {
        if(target == 0) {
            set.add(new ArrayList<>(arr));
            return;
        }

        if(target < 0) {
            return;
        }

        for(int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            arr.add(candidates[i]);
            backTrack(candidates, target - candidates[i], list, arr, set, i+1);
            arr.remove(arr.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();

        Arrays.sort(candidates);

        backTrack(candidates, target, list, new ArrayList<>(), set, 0);

        while(!set.isEmpty()) {
            List<Integer> element = set.iterator().next();
            list.add(element);
            set.remove(element);
        }

        return list;
    }
}