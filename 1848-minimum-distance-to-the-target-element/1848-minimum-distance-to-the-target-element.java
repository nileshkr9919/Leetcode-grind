class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                res = Math.min(res, (int) Math.abs(i - start));
            }
        }
        return res;
    }
}