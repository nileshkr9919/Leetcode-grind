function twoSum(nums: number[], target: number): number[] {
    const indexMap = new Map();

    for (let i = 0; i < nums.length; i++) {
        const complement = target - nums[i];
        if (indexMap.has(complement)) {
            return [i, indexMap.get(complement)];
        } else {
            indexMap.set(nums[i], i);
        }
    }
};