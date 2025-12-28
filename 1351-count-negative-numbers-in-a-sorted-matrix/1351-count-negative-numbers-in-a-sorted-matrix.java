class Solution {
    public int countNegatives(int[][] grid) {
        int res = 0, row = 0, col = grid[0].length - 1;

        while(row < grid.length && col >= 0) {
            if(grid[row][col] < 0) {
                res++;
                col--;
            } else {
                row++;
                col = grid[0].length - 1;
            }
        }

        return res;
    }
}