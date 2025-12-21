class Solution {
    int[] dp;

    Solution() {
        dp = new int[45];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
    }

    public int climbStairs(int n) {
        if (dp[n] != 0)
            return dp[n];

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}