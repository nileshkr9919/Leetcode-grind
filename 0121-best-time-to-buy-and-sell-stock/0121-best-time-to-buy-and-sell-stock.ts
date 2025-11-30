function maxProfit(prices: number[]): number {
    //Approach 1: Bruteforce
    // let maxProfit = 0, minPrice = prices[0];

    // for (let i = 1; i < prices.length; i++) {
    //     maxProfit = Math.max(maxProfit, prices[i] - minPrice);
    //     minPrice = Math.min(prices[i], minPrice);
    // }

    // return maxProfit;

    // Approach 2: DP (Bottom-up/ Tabulation)
    const n = prices.length;
    const dp = new Array(n).fill(0);

    let minPrice = prices[0];

    for (let i = 1; i < n; i++) {
        dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
        minPrice = Math.min(prices[i], minPrice);
    }

    return dp[n - 1];
};