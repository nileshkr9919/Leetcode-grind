function maximumHappinessSum(happiness: number[], k: number): number {
    happiness.sort((a, b) => b - a);

    let total = happiness[0];

    for (let i = 1; i < k; i++) {
        total += happiness[i]- i > 0 ? happiness[i] - i : 0;
    }

    return total;
};