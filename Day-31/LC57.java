class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> arrList = new ArrayList<>();
        int arr[][] = new int [intervals.length + 1][2];
        boolean consumed = false;
        int j = 0;
        
        for(int i = 0; i < intervals.length; i++) {
            if(newInterval[0] >= intervals[i][0] && !consumed) {
                arr[j] = intervals[i];
            } else if(!consumed) {
                arr[j] = newInterval;
                arr[j+1] = intervals[i];
                j++;
                consumed = true;
            } else {
                arr[j] = intervals[i];
            }

            j++;
        }

        if(!consumed) {
            arr[intervals.length] = newInterval;
        }


        arrList.add(arr[0]);

        for(int i = 1; i < arr.length; i++) {
            if(arr[i][0] <= arrList.get(arrList.size() - 1)[1]) {
                if(arr[i][1] > arrList.get(arrList.size() - 1)[1]) {
                    arrList.get(arrList.size() - 1)[1] = arr[i][1];
                }
            } else {
                arrList.add(arr[i]);
            }
        }

        return arrList.toArray(int[][]::new);
    }
}