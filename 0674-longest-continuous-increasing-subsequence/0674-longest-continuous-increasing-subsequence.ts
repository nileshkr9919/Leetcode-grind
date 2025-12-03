function findLengthOfLCIS(nums: number[]): number {
    let maxLen = 1, len = 1;
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] <= nums[i - 1]) {
            len = 1;
        } else {
            len++;
        }
        maxLen = Math.max(maxLen, len);
    }
    return maxLen;
};