class Solution {
    public void setZeroes(int[][] matrix) {
        HashMap<int[], Integer> map = new HashMap<>();

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    int arr[] = {i,j};

                    map.put(arr, 0);
                }
            }
        }

        Set<int[]> keys = map.keySet();

        for(int[] key: keys) {
            int i = key[0];
            int j = key[1];

            for(int x = 0; x < matrix.length; x++) {
                matrix[x][j] = 0;
            }

            for(int x = 0; x < matrix[0].length; x++) {
                matrix[i][x] = 0;
            }
        }
    }
}