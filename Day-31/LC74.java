class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix.length - 1;
        int idx = -1;

        while(i <= j) {
            int mid = i + (j - i) / 2;

            if(matrix[mid][0] <= target) {
                idx = mid;
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        if(idx == -1) {
            return false;
        }

        i = 0;
        j = matrix[0].length - 1;

        while(i <= j) {
            int mid = i + (j - i) / 2;

            if(matrix[idx][mid] == target) {
                return true;
            } else if(matrix[idx][mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return false;
    }
}