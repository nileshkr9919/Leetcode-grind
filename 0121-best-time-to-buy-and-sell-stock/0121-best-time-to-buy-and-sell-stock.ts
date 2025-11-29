function maxProfit(prices: number[]): number {
    let maxProfit = 0, minPrice = prices[0];

    for (let i = 1; i < prices.length; i++) {
        maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        minPrice = Math.min(prices[i], minPrice);
    }

    return maxProfit;
};