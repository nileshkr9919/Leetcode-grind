class Solution {
    public boolean containsCycle(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, i, j, -1, -1, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] grid, int i, int j, int prevRow, int prevCol, boolean[][] visited) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
            if (visited[i][j]) {
                return true;
            }
        } else {
            return false;
        }

        visited[i][j] = true;

        int[] rowDir = { 0, 0, 1, -1 };
        int[] colDir = { 1, -1, 0, 0 };

        for (int d = 0; d < 4; d++) {
            int nr = i + rowDir[d];
            int nc = j + colDir[d];
            if (nr == prevRow && nc == prevCol)
                continue;
            if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length)
                continue;
            if (grid[nr][nc] != grid[i][j])
                continue;
            if (visited[nr][nc])
                return true;
            if (dfs(grid, nr, nc, i, j, visited))
                return true;
        }
        return false;
    }
}