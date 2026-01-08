class Solution {
    public int arrangeCoins(int n) {
        return (int) (Math.floor(Math.sqrt(1L+ 8L * n) - 1) / 2);
    }
}