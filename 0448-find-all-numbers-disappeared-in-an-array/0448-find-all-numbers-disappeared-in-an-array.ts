function findDisappearedNumbers(nums: number[]): number[] {
    let i = 0;
    while (i < nums.length) {
        let pos = nums[i] - 1;

        if (nums[i] !== nums[pos]) {
            [nums[i], nums[pos]] = [nums[pos], nums[i]];
        } else {
            i++;
        }
    }

    const res = [];

    for (i = 0; i < nums.length; i++) {
        if (nums[i] !== i + 1) {
            res.push(i+1);
        }
    }

    return res;
};