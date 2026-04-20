class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;

        int left = 0;
        while (colors[left] == colors[n - 1])
            left++;
        int leftRes = (n - 1) - left;

        int right = n - 1;
        while (colors[right] == colors[0])
            right--;
        int rightRes = right;

        return Math.max(leftRes, rightRes);
    }
}