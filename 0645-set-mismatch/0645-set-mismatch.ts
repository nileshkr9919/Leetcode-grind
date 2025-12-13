function findErrorNums(nums: number[]): number[] {
    let i = 0;
    while (i < nums.length) {
        let pos = nums[i] - 1;

        if (nums[i] !== nums[pos]) {
            [nums[i], nums[pos]] = [nums[pos], nums[i]];
        } else {
            i++;
        }
    }

    for (i = 0; i < nums.length; i++) {
        if (nums[i] !== i + 1) {
            return [nums[i], i + 1];
        }
    }

    return [];
};