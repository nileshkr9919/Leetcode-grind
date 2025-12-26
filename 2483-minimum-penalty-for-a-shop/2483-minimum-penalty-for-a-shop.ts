function bestClosingTime(customers: string): number {
    const penalty = [];

    for (let i = 0; i <= customers.length; i++) {
        penalty[i] = 0;

        for (let prev = 0; prev < i; prev++) {
            if (customers[prev] === 'N') {
                penalty[i]++;
            }
        }

        for (let j = i; j < customers.length; j++) {
            if (customers[j] === 'Y') {
                penalty[i]++;
            }
        }
    }

    let minPenalty = penalty[0], minPenaltyIndex = 0;

    for (let i = 1; i < penalty.length; i++) {
        if (penalty[i] < minPenalty) {
            minPenalty = penalty[i];
            minPenaltyIndex = i;
        }
    }

    return minPenaltyIndex;
};