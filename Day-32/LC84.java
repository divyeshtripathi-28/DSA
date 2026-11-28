class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int nsr[] = new int[heights.length];
        int nsl[] = new int[heights.length];

        int st[] = new int[heights.length];
        int top = -1;

        for(int i = heights.length - 1; i >= 0; i--) {
            while(top != -1 && heights[st[top]] >= heights[i]) {
                top--;
            }

            if(top == -1) {
                nsr[i] = heights.length;
            } else {
                nsr[i] = st[top];
            }

            st[++top] = i;
        }

        top = -1;

        for(int i = 0; i < heights.length; i++) {
            while(top != -1 && heights[st[top]] >= heights[i]) {
                top--;
            }

            if(top == -1) {
                nsl[i] = -1;
            } else {
                nsl[i] = st[top];
            }

            st[++top] = i;
        }

        for(int i = 0; i < heights.length; i++) {
            int ht = heights[i];
            int wt = nsr[i] - nsl[i] - 1;

            maxArea = Math.max(maxArea, ht * wt);
        }

        return maxArea;
    }
}