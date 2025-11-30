function maxArea(height: number[]): number {
    let i = 0, j = height.length - 1, maxArea = 0;

    while (i < j) {
        maxArea = Math.max(maxArea, (j - i) * Math.min(height[j], height[i]));
        if (height[i] < height[j]) {
            i++;
        } else {
            j--;
        }
    }

    return maxArea;
};