function repeatedNTimes(nums: number[]): number {
    for (let i = 0; i < nums.length - 2; i++) {
        if (nums[i] === nums[i + 1] || nums[i] === nums[i + 2]) {
            return nums[i];
        }
    }
    // Edge case: if not found earlier
    return nums[nums.length - 1];
}
