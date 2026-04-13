class Solution {
    int[] rowDir = { -1, 1, 0, 0 };
    int[] colDir = { 0, 0, -1, 1 };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // Pattern matched: Flow problem - Reverse traversal

        int m = heights.length;
        int n = heights[0].length;

        Deque<int[]> pacificCells = new ArrayDeque<>();
        Deque<int[]> atlanticCells = new ArrayDeque<>();

        boolean[][] pacificVisited = new boolean[m][n];
        boolean[][] atlanticVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            pacificCells.add(new int[] { i, 0 });
            pacificVisited[i][0] = true;
            atlanticCells.add(new int[] { i, n - 1 });
            atlanticVisited[i][n - 1] = true;
        }

        for (int i = 0; i < n; i++) {
            pacificCells.add(new int[] { 0, i });
            pacificVisited[0][i] = true;
            atlanticCells.add(new int[] { m - 1, i });
            atlanticVisited[m - 1][i] = true;
        }

        bfs(heights, pacificCells, pacificVisited);
        bfs(heights, atlanticCells, atlanticVisited);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificVisited[i][j] && atlanticVisited[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    public void bfs(int[][] heights, Queue<int[]> queue, boolean[][] visited) {
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();

            int r = cell[0];
            int c = cell[1];

            for (int dir = 0; dir < 4; dir++) {
                int nr = r + rowDir[dir];
                int nc = c + colDir[dir];

                if (nr >= 0 && nc >= 0 && nr < heights.length && nc < heights[0].length && !visited[nr][nc]) {
                    if (heights[nr][nc] >= heights[r][c]) {
                        visited[nr][nc] = true;
                        queue.add(new int[] { nr, nc });
                    }
                }
            }
        }
    }
}