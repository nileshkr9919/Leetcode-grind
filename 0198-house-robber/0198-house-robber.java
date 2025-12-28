class Solution {
    public int rob(int[] nums) {
        int prev2 = 0, prev1 = 0;

        for(int n: nums) {
            int curr = Math.max(prev1, prev2 + n);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}