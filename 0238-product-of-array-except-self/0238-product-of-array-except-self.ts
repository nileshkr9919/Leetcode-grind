function productExceptSelf(nums: number[]): number[] {
    const res = [];

    let product = 1;
    for (const item of nums) {
        res.push(product);
        product *= item;
    }
    product = 1;
    for (let i = nums.length - 1; i >= 0; i--) {
        res[i] *= product;
        product *= nums[i];
    }

    return res;
};