class Solution {
    public int minOperations(int[][] grid, int x) {
        int[] nums = new int[grid.length * grid[0].length];
        int idx = 0;
        int rem = grid[0][0] % x;

        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                nums[idx++] = grid[i][j];
                if(grid[i][j] % x != rem) {
                    return -1;
                }
            }
        }

        Arrays.sort(nums);

        int median = nums[nums.length / 2];
        int ops = 0;

        for(int num : nums) {
            ops += Math.abs(num - median) / x;
        }

        return ops;
    }
}