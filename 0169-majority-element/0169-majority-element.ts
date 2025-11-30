function majorityElement(nums: number[]): number {
    let candidate = 0, count = 0;

    for (const item of nums) {
        if (count == 0) {
            candidate = item;
            count++;
        } else if (item !== candidate) {
            count--;
        } else {
            count++;
        }
    }

    return candidate;
};