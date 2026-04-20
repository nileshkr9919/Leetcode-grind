class Solution {
    public int maxDistance(int[] colors) {
        int left = 0, right = colors.length - 1, leftRes = 0, rightRes = 0;

        while (left <= right) {
            if (colors[left] != colors[right]) {
                leftRes = right - left;
                break;
            } else {
                left++;
            }
        }

        left = 0;

        while (left <= right) {
            if (colors[left] != colors[right]) {
                rightRes = right - left;
                break;
            } else {
                right--;
            }
        }

        return Math.max(rightRes, leftRes);
    }
}