class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int k = 0;

        int arr[] = new int [nums1.length + nums2.length];

        while(i != nums1.length && j != nums2.length) {
            if(nums1[i] <= nums2[j]) {
                arr[k] = nums1[i];
                i++;
            } else {
                arr[k] = nums2[j];
                j++;
            }

            k++;
        }

        while(i != nums1.length) {
            arr[k] = nums1[i];
            i++;

            k++;
        }

        while(j != nums2.length) {
            arr[k] = nums2[j];
            j++;

            k++;
        }

        if(arr.length % 2 == 0) {
            int num1 = arr[arr.length/2 - 1];
            int num2 = arr[arr.length/2];

            double sum = num1 + num2;

            return sum/2;
        } else {
            return (double) arr[arr.length/2];
        }

        }
}