class Solution {
    int[] rowDir = { -1, 1, 0, 0 };
    int[] colDir = { 0, 0, -1, 1 };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        Deque<int[]> pacQueue = new LinkedList<>();
        Deque<int[]> atlQueue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            pacQueue.add(new int[] { i, 0 });
            pacific[i][0] = true;
            atlQueue.add(new int[] { i, n - 1 });
            atlantic[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            pacQueue.add(new int[] { 0, j });
            pacific[0][j] = true;
            atlQueue.add(new int[] { m - 1, j });
            atlantic[m - 1][j] = true;
        }

        bfs(heights, pacQueue, pacific);
        bfs(heights, atlQueue, atlantic);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (pacific[i][j] && atlantic[i][j])
                    result.add(Arrays.asList(i, j));

        return result;
    }

    private void bfs(int[][] heights, Deque<int[]> queue, boolean[][] visited) {
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int dir = 0; dir < 4; dir++) {
                int nr = r + rowDir[dir];
                int nc = c + colDir[dir];

                if (nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length
                        && !visited[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                    visited[nr][nc] = true;
                    queue.add(new int[] { nr, nc });
                }
            }
        }
    }
}