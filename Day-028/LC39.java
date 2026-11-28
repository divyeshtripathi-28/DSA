class Solution {
    public void backTrack(int[] candidates, List<List<Integer>> list, List<Integer> arr, int target, int start) {
        if(target == 0) {
            list.add(new ArrayList<>(arr));
            return;
        }

        if(target < 0) {
            return;
        }

        for(int i = start; i < candidates.length; i++) {
            arr.add(candidates[i]);
            backTrack(candidates, list, arr, target - candidates[i], i);
            arr.remove(arr.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        
        Arrays.sort(candidates);

        backTrack(candidates, list, new ArrayList<>(), target, 0);

        return list;
    }
}