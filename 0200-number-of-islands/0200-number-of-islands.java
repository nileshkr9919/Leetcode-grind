class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

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

    // DFS APProach
    // private void dfs(char[][] grid, int i, int j) {
    //     if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
    //         return;
    //     }

    //     grid[i][j] = '0';
    //     dfs(grid, i - 1, j);
    //     dfs(grid, i + 1, j);
    //     dfs(grid, i, j - 1);
    //     dfs(grid, i, j + 1);
    // }

    // BFS Approach
    private void bfs(char[][] grid, int i, int j) {
        Deque<int[]> queue = new LinkedList<>();
        grid[i][j] = '0';
        queue.add(new int[] { i, j });

        int[] rowDir = { -1, 1, 0, 0 };
        int[] colDir = { 0, 0, -1, 1 };

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();

            int a = cell[0];
            int b = cell[1];

            for (int dir = 0; dir < 4; dir++) {
                int nr = a + rowDir[dir];
                int nc = b + colDir[dir];
                if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length || grid[nr][nc] == '0') {
                    continue;
                }
                grid[nr][nc] = '0';
                queue.add(new int[] { nr, nc });
            }
        }
    }
}