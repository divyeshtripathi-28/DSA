class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        digits[n - 1] = digits[n - 1] + 1;

        for(int i = n-1; i>0; i--){
            if(digits[i] == 10){
                digits[i] = 0;
                digits[i-1] = digits[i-1] + 1;
            }
        }

        if(digits[0] == 10){
            int arr[] = new int [n+1];
            arr[0] = 1;
            arr[1] = 0;
            for(int i=2; i<=n; i++){
                arr[i] = digits[i-1];
            }
            return arr;
        }

        return digits;
    }
}