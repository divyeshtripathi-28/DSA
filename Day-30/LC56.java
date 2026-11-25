class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> arr = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        arr.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {
            int lastMerge [] = arr.get(arr.size() - 1);
            int endLast = lastMerge[1];

            if(intervals[i][0] <= endLast && intervals[i][1] > endLast) {
                lastMerge[1] = intervals[i][1];
            } else if(intervals[i][0] > endLast) {
                arr.add(intervals[i]);
            }
        }

        return arr.toArray(new int[arr.size()][2]);
    }
}