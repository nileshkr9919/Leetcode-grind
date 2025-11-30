/**
 Do not return anything, modify nums in-place instead.
 */
function sortColors(nums: number[]): void {
    const buckets = [0, 0, 0];
    for (const item of nums) {
        buckets[item]++;
    }
    let index = 0;

    for (let color = 0; color < 3; color++) {
        for (let i = 0; i < buckets[color]; i++) {
            nums[index++] = color;
        }
    }
};