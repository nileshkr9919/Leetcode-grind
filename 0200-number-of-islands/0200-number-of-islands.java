class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length, count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }

        return count;
    }

    // DFS Approach
    // private void dfs(char[][] grid, int i, int j) {
    //     if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
    //         return;
    //     }

    //     grid[i][j] = '0';

    //     dfs(grid, i, j + 1);
    //     dfs(grid, i, j - 1);
    //     dfs(grid, i - 1, j);
    //     dfs(grid, i + 1, j);

    //     return;
    // }

    // BFS Approach
    private void bfs(char[][] grid, int idx, int jdx) {
        Deque<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        int[] rowDir = { -1, 0, 0, 1};
        int[] colDir = { 0, -1, 1, 0};

        queue.add(new int[] { idx, jdx });

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0];
            int j = cell[1];

            for (int dir = 0; dir < 4; dir++) {
                int nr = i + rowDir[dir];
                int nc = j + colDir[dir];

                if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1') {
                    grid[nr][nc] = '0';
                    queue.add(new int[] { nr, nc });
                }
            }
        }
        grid[idx][jdx] = '0';
    }
}