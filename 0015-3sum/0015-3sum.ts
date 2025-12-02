function threeSum(nums: number[]): number[][] {
    nums.sort((a, b) => a - b);
    const res = [];

    for (let i = 0; i < nums.length - 2; i++) {
        if (nums[i] > 0) return res;
        if (i > 0 && nums[i] === nums[i - 1]) continue;

        const target = -(nums[i]);
        let left = i + 1, right = nums.length - 1;

        while (left < right) {
            const sum = nums[i] + nums[left] + nums[right];

            if (sum === 0) {
                res.push([nums[i], nums[left], nums[right]]);

                left++;
                right--;

                while (left < right && nums[left] === nums[left - 1]) left++;
                while (left < right && nums[right] === nums[right + 1]) right--;
            }
            else if (sum < 0) left++;
            else right--;
        }

    }

    return res;
};