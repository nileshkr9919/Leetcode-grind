class Solution {
    public int climbStairs(int n) {
        if (n <= 2)
            return n;

        int prev1 = 1, prev = 2;

        for (int i = 3; i <= n; i++) {
            int temp = prev + prev1;
            prev1 = prev;
            prev = temp;
        }

        return prev;
    }
}