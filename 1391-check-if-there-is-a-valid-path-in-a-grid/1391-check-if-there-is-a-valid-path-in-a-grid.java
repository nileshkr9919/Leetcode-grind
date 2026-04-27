class Solution {
    public boolean hasValidPath(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return dfs(grid, 0, 0, visited);
    }

    private int[] rowDir = new int[] { -1, 1, 0, 0 };
    private int[] colDir = new int[] { 0, 0, -1, 1 };

    private boolean dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;

        if (i == m - 1 && j == n - 1)
            return true;

        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j])
            return false;

        visited[i][j] = true;

        for (int dir = 0; dir < 4; dir++) {
            if (!canMove(grid[i][j], dir))
                continue;

            int nr = i + rowDir[dir];
            int nc = j + colDir[dir];

            if (nr < 0 || nc < 0 || nr >= m || nc >= n || visited[nr][nc])
                continue;

            if (!canMove(grid[nr][nc], opposite(dir)))
                continue;

            if (dfs(grid, nr, nc, visited))
                return true;
        }

        return false;
    }

    private boolean canMove(int type, int dir) {
        switch (type) {
            case 1:
                return dir == 2 || dir == 3; // left, right
            case 2:
                return dir == 0 || dir == 1; // up, down
            case 3:
                return dir == 2 || dir == 1; // left, down
            case 4:
                return dir == 3 || dir == 1; // right, down
            case 5:
                return dir == 2 || dir == 0; // left, up
            case 6:
                return dir == 3 || dir == 0; // right, up
        }
        return false;
    }

    private int opposite(int dir) {
        if (dir == 0)
            return 1; // up -> down
        if (dir == 1)
            return 0; // down -> up
        if (dir == 2)
            return 3; // left -> right
        return 2; // right -> left
    }
}