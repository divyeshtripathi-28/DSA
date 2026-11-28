class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax[] = new int [n];
        int rightMax[] = new int [n];

        leftMax[0] = 0;
        int leftMaxNum = 0;
        

        for(int i = 1; i < n; i++) {
            if(leftMaxNum < height[i - 1]) {
                leftMaxNum = height[i - 1];
            }

            leftMax[i] = leftMaxNum;
        }

        rightMax[n - 1] = 0;
        int rightMaxNum = 0;

        for(int i = n - 2; i >= 0; i--) {
            if(rightMaxNum < height[i + 1]) {
                rightMaxNum = height[i + 1];
            }

            rightMax[i] = rightMaxNum;
        }

        int totalWater = 0;

        for(int i = 0; i < n; i++) {
            int water = Math.min(rightMax[i], leftMax[i]) - height[i];

            if(water > 0) {
                totalWater += water;
            }
        }

        return totalWater;
    }
}