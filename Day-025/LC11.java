class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxWater = 0;
        while(i<j) {
            if(height[i] < height[j]) {
                if(maxWater < height[i] * (j-i)) {
                    maxWater = height[i] * (j-i);
                }
                i++;
            } else {
                if(maxWater < height[j] * (j-i)) {
                    maxWater = height[j] * (j-i);
                }
                j--;
            }
        }

        return maxWater;
    }
}