function coinChange(coins: number[], amount: number): number {
    const memo = new Map<number, number>();
    memo.set(0, 0);

    function dfs(rem: number): number {
        if (rem < 0) return -1;
        if (memo.has(rem)) return memo.get(rem)!;

        let min = Infinity;

        for (const coin of coins) {
            const res = dfs(rem - coin);
            if (res !== -1) {
                min = Math.min(min, res + 1);
            }
        }

        const ans = min === Infinity ? -1 : min;
        memo.set(rem, ans);
        return ans;
    }

    return dfs(amount);
}
