class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1, indexA = m - 1, indexB = n - 1;

        while (indexA >= 0 && indexB >= 0) {
            if (nums1[indexA] >= nums2[indexB]) {
                nums1[index--] = nums1[indexA--];
            } else {
                nums1[index--] = nums2[indexB--];
            }
        }

        while (indexA >= 0) {
            nums1[index--] = nums1[indexA--];
        }

        while (indexB >= 0) {
            nums1[index--] = nums2[indexB--];
        }
    }
}