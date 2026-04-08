class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = 1_000_000_007;
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int k = query[2];
            int v = query[3];

            int idx = l;

            while (idx <= r) {
                nums[idx] = (int)((1L * nums[idx] * v) % MOD);
                idx += k;
            }
        }

        int res = 0;

        for (int n : nums) {
            res ^= n;
        }

        return res;
    }
}