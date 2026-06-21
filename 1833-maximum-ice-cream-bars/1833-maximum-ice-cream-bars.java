class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0;

        for (int i = 0; i < costs.length; i++) {
            if (coins < costs[i]) {
                return res;
            }
            res++;
            coins -= costs[i];
        }

        return res;
    }
}