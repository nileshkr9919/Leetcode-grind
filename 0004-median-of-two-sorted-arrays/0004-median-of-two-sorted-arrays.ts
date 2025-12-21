function findMedianSortedArrays(nums1: number[], nums2: number[]): number {
    const merged: number[] = [];
    let i = 0, j = 0;

    while (i < nums1.length && j < nums2.length) {
        if (nums1[i] <= nums2[j]) merged.push(nums1[i++]);
        else merged.push(nums2[j++]);
    }

    while (i < nums1.length) merged.push(nums1[i++]);
    while (j < nums2.length) merged.push(nums2[j++]);


    const n = merged.length;
    if (n % 2 === 1) return merged[Math.floor(n / 2)];
    return (merged[n / 2 - 1] + merged[n / 2]) / 2;
};